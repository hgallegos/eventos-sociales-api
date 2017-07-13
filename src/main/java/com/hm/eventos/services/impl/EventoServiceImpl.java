package com.hm.eventos.services.impl;

import com.hm.eventos.domain.*;
import com.hm.eventos.repositories.EventoCategoriaRepository;
import com.hm.eventos.repositories.EventoFotoRepository;
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
import java.util.*;
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
    private static final String[] ALL_FIELDS = new String[]{"id", "cover", "description", "end_time", "name", "owner", "parent_group", "start_time", "ticket_uri", "timezone", "updated_time", "place"};
    private static final int MUSICA = 8;
    private static final int CULTURAl = 1;
    private static final int VIDA_NOCTURNA = 6;
    private static final int MISC = 2;
    private static final int FAMILIAR = 10;

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EventoFotoRepository eventoFotoRepository;

    @Autowired
    EventoCategoriaRepository eventoCategoriaRepository;


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
            Evento evento = eventoRepository.save(facebookEventToEvento(event));
            if (event.getCover() == null) {
                event = facebook.fetchObject(event.getId(), Event.class, ALL_FIELDS);
                if(event.getCover() == null || !event.getCover().getSource().startsWith("https")) {
                    eventoRepository.delete(evento);
                    return null;
                }
            }
            List<EventoFoto> fotos = new ArrayList<>();
            EventoFoto eventoFoto = eventoFotoFromEvent(event, evento);
            if(eventoFoto != null && eventoFoto.getUrl().startsWith("https")) {
                fotos.add(eventoFotoRepository.save(eventoFotoFromEvent(event, evento)));
                evento.setEventoFotos(fotos);
            }
            evento.setAsignaCategorias(getCategories(evento.getDescripcion(), evento));
            if(!evento.getAsignaCategorias().isEmpty()) {
                eventoRepository.save(evento);
            }
            return evento;
        } else {
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
        evento.setListaInvitados(new ArrayList<ListaInvitado>());
        evento.setpNombre("" + event.getPlace().getName());
        evento.setpDireccion("" + event.getPlace().getLocation().getStreet() + ", " + event.getPlace().getLocation().getCity());
        evento.setpLat(event.getPlace().getLocation().getLatitude());
        evento.setpLng(event.getPlace().getLocation().getLongitude());
        evento.setpTipo(FACEBOOK_TYPE);
        evento.setUsuario(usuario());
        evento.setFacebookId(Long.parseLong(event.getId()));

        return evento;
    }

    private EventoFoto eventoFotoFromEvent(Event event, Evento evento) {
        if(event.getCover().getSource() != null){
            EventoFoto foto = new EventoFoto();
            foto.setTitulo(event.getName());
            foto.setDescripcion("");
            foto.setUrl(event.getCover().getSource());
            foto.setEvento(evento);
            return foto;
        } else {
            return null;
        }

    }

    private Usuario usuario() {
        return usuarioRepository.findOne(FACEBOOK_USER);
    }

    private Facebook getFacebook() {
        facebookTemplate.setApiVersion("2.9");
        return facebookTemplate;
    }

    private Set<AsignaCategoria> getCategories(String description, Evento evento) {
        Set<AsignaCategoria> asignaCategorias = new HashSet<>();
        AsignaCategoria asignaCategoria = new AsignaCategoria();
        boolean oneAtLeast = false;
        if (description.contains("usica") || description.contains("úsica") || description.contains("oncierto")) {
            asignaCategoria.setCategoria(eventoCategoriaRepository.findOne(MUSICA));
            asignaCategoria.setEvento(evento);
            asignaCategorias.add(asignaCategoria);
            oneAtLeast = true;
        }
        if (description.contains("ultura")) {
            asignaCategoria.setEvento(evento);
            asignaCategoria.setCategoria(eventoCategoriaRepository.findOne(CULTURAl));
            asignaCategorias.add(asignaCategoria);
            oneAtLeast = true;
        }
        if (description.contains("amilia")) {
            asignaCategoria.setEvento(evento);
            asignaCategoria.setCategoria(eventoCategoriaRepository.findOne(FAMILIAR));
            asignaCategorias.add(asignaCategoria);
            oneAtLeast = true;
        }
        if (description.contains("pub") || description.contains("Pub") || description.contains("Noche") || description.contains("noche") || description.contains("octurna")) {
            asignaCategoria.setCategoria(eventoCategoriaRepository.findOne(VIDA_NOCTURNA));
            asignaCategoria.setEvento(evento);
            asignaCategorias.add(asignaCategoria);
            oneAtLeast = true;
        }
        if(!oneAtLeast) {
            asignaCategoria.setCategoria(eventoCategoriaRepository.findOne(MISC));
            asignaCategoria.setEvento(evento);
            asignaCategorias.add(asignaCategoria);
        }

        return asignaCategorias;
    }
}
