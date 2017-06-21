package com.hm.eventos.services.impl;

import com.hm.eventos.domain.Evento;
import com.hm.eventos.repositories.EventoRepository;
import com.hm.eventos.services.EventoService;
import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.LatLngTool;
import com.javadocmd.simplelatlng.util.LengthUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hans6 on 17-06-2017.
 */
@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    EventoRepository eventoRepository;

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
}
