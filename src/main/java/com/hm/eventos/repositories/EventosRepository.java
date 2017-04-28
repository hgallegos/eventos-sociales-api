package com.hm.eventos.repositories;

import com.hm.eventos.domain.MgEventos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 27-04-2017.
 */
@RepositoryRestResource(collectionResourceRel = "eventos", path = "eventos")
public interface EventosRepository extends JpaRepository<MgEventos, Integer> {
}
