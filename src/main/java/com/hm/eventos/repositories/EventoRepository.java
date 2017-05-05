package com.hm.eventos.repositories;

import com.hm.eventos.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by hans6 on 27-04-2017.
 */
@RepositoryRestResource(collectionResourceRel = "eventos", path = "eventos")
public interface EventoRepository extends JpaRepository<Evento, Integer> {
}
