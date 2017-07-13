package com.hm.eventos.handlers;

import com.hm.eventos.domain.Actividad;
import com.hm.eventos.domain.Evento;
import com.hm.eventos.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.RequestHandledEvent;
import org.springframework.web.context.support.ServletRequestHandledEvent;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * Created by hans6 on 11-07-2017.
 */
@Component
@RepositoryEventHandler(Evento.class)
public class EventosEventHandler {
    private static final String MODIFICAR = "modificar_evento";
    private static final String CREAR = "crear_evento";
    private static final String ELIMINAR = "eliminar_evento";
    private Actividad actividad = null;

    @Autowired
    private ActividadRepository actividadRepository;

    @EventListener
    public void eventListener(ServletRequestHandledEvent e) {
        if(actividad != null) {
            actividad.setIp(e.getClientAddress());
            actividadRepository.save(actividad);
            actividad = null;
        }
    }

    @HandleBeforeSave
    public void handleEventoSave(Evento evento) {
        actividad = new Actividad();
        actividad.setApiId(1);
        if(evento.getId() > 0) {
            actividad.setUsuario(evento.getUsuario());
            actividad.setTipo(MODIFICAR);
            actividad.setFecha(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        } else {
            actividad.setUsuario(evento.getUsuario());
            actividad.setTipo(CREAR);
            actividad.setFecha(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        }
    }

    @HandleBeforeDelete
    public void handleEventoDelete(Evento evento) {
        actividad = new Actividad();
        actividad.setApiId(1);
        actividad.setUsuario(evento.getUsuario());
        actividad.setTipo(ELIMINAR);
        actividad.setFecha(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
    }

}
