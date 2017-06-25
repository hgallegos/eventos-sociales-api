package com.hm.eventos.controllers;

import com.hm.eventos.domain.Evento;
import com.hm.eventos.domain.assembler.EventoResource;
import com.hm.eventos.domain.assembler.EventoResourceAssembler;
import com.hm.eventos.repositories.EventoRepository;
import com.hm.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by hans6 on 01-05-2017.
 */
@RepositoryRestController
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private EventoResourceAssembler eventoResourceAssembler;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PagedResourcesAssembler<Evento> pagedAssembler;


    @GetMapping(value = "/eventos/search/near_eventos")
    @ResponseBody
    public ResponseEntity<Resources<Resource<Evento>>> getNearEventos(@RequestParam("lat") double lat, @RequestParam("lng") double lng, @PageableDefault(page = 0, size = 20) Pageable pageable) {
        Page<Evento> nearEventos = eventoService.getEventosNearTo(lat, lng);

        // Page<Evento> eventos = eventoRepository.findAll(pageable);

        Resources<Evento> resources = new Resources<>(nearEventos);

        //resources.add(linkTo(methodOn(EventoController.class).getNearEventos(lat, lng)).withSelfRel());

        return ResponseEntity.ok(pagedAssembler.toResource(nearEventos));
    }

    @GetMapping(value = "/eventos/search/query")
    @ResponseBody
    public ResponseEntity<Resources<Resource<Evento>>> getEventosByNombreDireccionAndCategoria(@RequestParam(value = "nombre", required = false, defaultValue = "") String nombre,
                                                                                     @RequestParam(value = "direccion", required = false, defaultValue = "") String direccion,
                                                                                     @RequestParam(value = "categoria", required = false, defaultValue = "") String categoria,
                                                                                     @PageableDefault(page = 0, size = 20) Pageable pageable) {

        Page<Evento> eventosByNombreDireccionAndCategoria = eventoService.getEventosBy(nombre, direccion, categoria);

        return ResponseEntity.ok(pagedAssembler.toResource(eventosByNombreDireccionAndCategoria));
    }

}
