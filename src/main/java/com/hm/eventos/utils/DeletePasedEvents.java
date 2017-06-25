package com.hm.eventos.utils;

import com.hm.eventos.domain.Evento;
import com.hm.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

/**
 * Created by hans6 on 25-06-2017.
 */
public class DeletePasedEvents {

    @Autowired
    EventoService eventoService;

    public void eliminaEventosPasados() {
        eventoService.getAll().stream()
                .filter(e -> e.getFechaFin().getTime() < Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)).getTime())
                .forEach(e -> eventoService.delete(e));
    }
}
