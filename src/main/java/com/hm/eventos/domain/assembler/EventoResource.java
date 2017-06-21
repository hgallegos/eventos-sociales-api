package com.hm.eventos.domain.assembler;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by hans6 on 17-06-2017.
 */
public class EventoResource extends ResourceSupport {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
