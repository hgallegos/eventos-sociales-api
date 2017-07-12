package com.hm.eventos.controllers;

import com.hm.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.social.facebook.api.*;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hans6 on 24-06-2017.
 */
@RepositoryRestController
@BasePathAwareController
public class FacebookController {

    @Autowired
    private EventoService eventoService;

    public static final String TOKEN = "EAARbj8vHJP0BAE0OfRSz9ZCXcn9XgsliksOYbigBN0ZBBQ3uJUeQ1Ed1z4jneZB65nnx26tWIZAZA1rbldKMlmZBZB7xzuemrBRHJsc7c6nQVMJG50VBZBTp0du0ZB6zn8kS9j0sVoUByZAcXuTaEEaZAXrwDqcsCDfUGNbc2bWFI7iTgZDZD";
    private static final String DEFAULT_COUNTRY = "chile";

    private FacebookTemplate facebookTemplate = new FacebookTemplate(TOKEN);
    private Facebook facebook = getFacebook();

    @GetMapping(value = "/facebook")
    @ResponseBody
    public ResponseEntity<String> saveEventsFromFacebook() {
        PagedList<Event> events = getListOfEventsByCountry(getEventsFromFracebook(DEFAULT_COUNTRY, null), DEFAULT_COUNTRY);
        if (events != null) {
            for (Event event :
                    events) {
                eventoService.saveEventoFromFacebook(event);

            }
            saveNextEvents(events);
        }


        return ResponseEntity.ok("ok");
    }

    private void saveNextEvents(PagedList<Event> events) {
        if (events.getNextPage() != null) {
            PagedList<Event> nextEvents = getListOfEventsByCountry(getEventsFromFracebook(DEFAULT_COUNTRY, events.getNextPage()), DEFAULT_COUNTRY);
            if (nextEvents != null) {
                nextEvents.forEach(event -> eventoService.saveEventoFromFacebook(event));
                this.saveNextEvents(nextEvents);
            }
        }

    }

    private PagedList<Event> getEventsFromFracebook(String query, PagingParameters pagingParameters) {
        if (pagingParameters != null) {
            return facebook.eventOperations().search(query, pagingParameters);
        } else {
            return facebook.eventOperations().search(query);
        }
    }

    private Facebook getFacebook() {
        facebookTemplate.setApiVersion("2.9");
        return facebookTemplate;
    }

    private PagedList<Event> getListOfEventsByCountry(PagedList<Event> events, String country) {
        if (events.size() > 0) {
            List<Event> eventList = events.subList(0, events.size());
            eventList = eventList.stream()
                    .filter(e -> e.getPlace() != null)
                    .filter(e -> e.getEndTime() != null)
                    .filter(e -> e.getPlace().getLocation() != null)
                    .filter(e -> e.getPlace().getLocation().getStreet() != null)
                    .filter(e -> e.getPlace().getLocation().getCountry() != null)
                    .filter(e -> e.getPlace().getLocation().getCountry().equalsIgnoreCase(DEFAULT_COUNTRY))
                    .filter(e -> (e.getEndTime().getTime() >= Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).getTime()))
                    .collect(Collectors.toList());
            return new PagedList<>(eventList, events.getPreviousPage(), events.getNextPage());
        } else {
            return null;
        }
    }
}
