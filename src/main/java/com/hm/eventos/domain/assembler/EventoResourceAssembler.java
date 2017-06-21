package com.hm.eventos.domain.assembler;

import com.hm.eventos.controllers.EventoController;
import com.hm.eventos.domain.Evento;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by hans6 on 17-06-2017.
 */
@Component
public class EventoResourceAssembler extends ResourceAssemblerSupport<Evento, EventoResource> {

    public EventoResourceAssembler() {
        super(EventoController.class, EventoResource.class);
    }
    @Override
    public EventoResource toResource(Evento evento) {
        EventoResource eventoResource = createResourceWithId(evento.getId(), evento);
        eventoResource.setName(evento.getNombre());
        return eventoResource;
    }
}
