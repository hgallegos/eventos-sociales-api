package com.hm.eventos.controllers;

import com.hm.eventos.services.EventoService;
import com.hm.eventos.utils.SaveEventsFromFacebook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(FacebookController.class);

    @Autowired
    private EventoService eventoService;

    public static final String TOKEN = "EAARbj8vHJP0BAE0OfRSz9ZCXcn9XgsliksOYbigBN0ZBBQ3uJUeQ1Ed1z4jneZB65nnx26tWIZAZA1rbldKMlmZBZB7xzuemrBRHJsc7c6nQVMJG50VBZBTp0du0ZB6zn8kS9j0sVoUByZAcXuTaEEaZAXrwDqcsCDfUGNbc2bWFI7iTgZDZD";
    private static final String DEFAULT_COUNTRY = "chile";

    private String query = "chile";

    private FacebookTemplate facebookTemplate = new FacebookTemplate(TOKEN);
    private Facebook facebook = getFacebook();

    @GetMapping(value = "/facebook")
    @ResponseBody
    public ResponseEntity<String> saveEventsFromFacebook() {
        saveFirstEvents();


        return ResponseEntity.ok("ok");
    }

    private void saveFirstEvents() {
        log.info("The time is now{}", LocalDateTime.now());
        PagedList<Event> events = getListOfEventsByCountry(getEventsFromFracebook(query, null), DEFAULT_COUNTRY);
        if (events != null) {
            log.info("Guardando " + events.size() + " eventos");
            for (Event event :
                    events) {
                eventoService.saveEventoFromFacebook(event);
            }
            log.info("Eventos guardados");
            saveNextEvents(events);
        }
    }

    private void saveNextEvents(PagedList<Event> events) {
        if (events.getNextPage() != null) {
            PagedList<Event> nextEvents = getListOfEventsByCountry(getEventsFromFracebook(query, events.getNextPage()), DEFAULT_COUNTRY);
            if (nextEvents != null) {
                log.info("Guardando " + nextEvents.size() + " eventos");
                nextEvents.forEach(event -> eventoService.saveEventoFromFacebook(event));
                log.info("Eventos guardados");
                this.saveNextEvents(nextEvents);
            } else {
                this.query = changeQuery();
                if (this.query != null) {
                    this.saveFirstEvents();
                }

            }
        }

    }

    private String changeQuery() {
        switch (query) {
            case "chile":
                return "santiago";
            case "santiago":
                return "chillan";
            case "chillan":
                return "concepcion";
            case "concepcion":
                return "valparaiso";
            case "valparaiso":
                return "viña del mar";
            case "viña del mar":
                return "arica";
            case "arica":
                return "puerto montt";
            case "puerto montt":
                return "la serena";
            case "la serena":
                return "los angeles";
            case "los angeles":
                return null;

            default:
                return null;
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
