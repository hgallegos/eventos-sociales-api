package com.hm.eventos.services;

import com.hm.eventos.domain.Evento;
import org.springframework.data.domain.Page;
import org.springframework.social.facebook.api.Event;

import java.util.List;

/**
 * Created by hans6 on 17-06-2017.
 */
public interface EventoService {

    Page<Evento> getEventosNearTo(double lat, double lng);

    Page<Evento> getEventosBy(String nombre, String direccion, String categoria);

    Evento saveEventoFromFacebook(Event event);

    List<Evento> getAll();

    void delete(Evento evento);
}
