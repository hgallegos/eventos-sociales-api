package com.hm.eventos.services.impl;

import com.hm.eventos.domain.Evento;
import com.hm.eventos.domain.Usuario;
import com.hm.eventos.repositories.EventoRepository;
import com.hm.eventos.repositories.UsuarioRepository;
import com.hm.eventos.services.EventoService;
import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.hm.eventos.controllers.FacebookController.TOKEN;

/**
 * Created by hans6 on 17-06-2017.
 */
@Service
public class EventoServiceImpl implements EventoService {

    private static final String PUBLICO = "PUBLICO";
    private static final String FACEBOOK_TYPE = "from Facebook";
    private static final int FACEBOOK_USER = 103;

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    private FacebookTemplate facebookTemplate = new FacebookTemplate(TOKEN);
    private Facebook facebook = getFacebook();

    @Override
    public Page<Evento> getEventosNearTo(double lat, double lng) {
        List<Evento> eventos = eventoRepository.findAll().stream().filter(evento -> {
            double distance = calculateDistanceInKilometers(point(lat, lng), point(evento.getpLat(), evento.getpLng()));
            System.out.println(distance);
            return isNearTo(distance);
        }).collect(Collectors.toList());

        return makePage(eventos);
    }

    @Override
    public Page<Evento> getEventosBy(String nombre, String direccion, String categoria) {

        List<Evento> results = eventoRepository.findAll().stream()
                .filter(e -> e.getNombre().startsWith(nombre))
                .filter(e -> e.getpDireccion().startsWith(direccion))
                .filter(e -> e.getAsignaCategorias().stream().anyMatch(c -> c.getCategoria().getNombre().startsWith(categoria)))
                .collect(Collectors.toList());

        return makePage(results);
    }

    @Override
    public Evento saveEventoFromFacebook(Event event) {
        if (eventoRepository.findByFacebookId(Long.parseLong(event.getId())) == null) {
            if (event.getCover() != null) {
                System.out.println(event.getCover().getSource());
            } else {
                event = facebook.eventOperations().getEvent(event.getId());
            }
            return eventoRepository.save(facebookEventToEvento(event));
        } else {
            if (event.getCover() != null) {
                System.out.println(event.getCover().getSource());
            }
            return null;
        }
    }

    @Override
    public List<Evento> getAll() {
        return eventoRepository.findAll();
    }

    @Override
    public void delete(Evento evento) {
        eventoRepository.delete(evento);
    }

    private double calculateDistanceInKilometers(LatLng point1, LatLng point2) {
        return LatLngTool.distance(point1, point2, LengthUnit.KILOMETER);
    }

    private boolean isNearTo(double distance) {
        return distance < 10;
    }

    private LatLng point(double lat, double lng) {
        return new LatLng(lat, lng);
    }

    private Page<Evento> makePage(List<Evento> eventos) {
        return new PageImpl<Evento>(eventos, new PageRequest(0, 20), eventos.size());
    }

    private Evento facebookEventToEvento(Event event) {

        Evento evento = new Evento();
        evento.setNombre("" + event.getName());
        evento.setDescripcion("" + event.getDescription());
        evento.setFechaRegistro(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        evento.setFechaInicio(event.getStartTime());
        evento.setFechaFin(event.getEndTime());
        evento.setVisibilidad(PUBLICO);
        evento.setpNombre("" + event.getPlace().getName());
        evento.setpDireccion("" + event.getPlace().getLocation().getStreet() + ", " + event.getPlace().getLocation().getCity());
        evento.setpLat(event.getPlace().getLocation().getLatitude());
        evento.setpLng(event.getPlace().getLocation().getLongitude());
        evento.setpTipo(FACEBOOK_TYPE);
        evento.setUsuario(usuario());
        evento.setFacebookId(Long.parseLong(event.getId()));

        return evento;
    }

    private Usuario usuario() {
        return usuarioRepository.findOne(FACEBOOK_USER);
    }

    private Facebook getFacebook() {
        facebookTemplate.setApiVersion("2.9");
        return facebookTemplate;
    }
}
