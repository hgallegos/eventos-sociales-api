package com.hm.eventos.repositories;

import com.hm.eventos.domain.EventoFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 05-05-2017.
 */
public interface EventoFotoRepository extends JpaRepository<EventoFoto, Integer> {
}
