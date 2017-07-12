package com.hm.eventos.repositories;

import com.hm.eventos.domain.EventoFoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 11-07-2017.
 */
@RepositoryRestResource(collectionResourceRel = "evento_fotos", path="eventos_fotos")
public interface EventoFotoRepository extends JpaRepository<EventoFoto, Integer> {
}
