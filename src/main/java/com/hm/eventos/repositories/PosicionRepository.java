package com.hm.eventos.repositories;

import com.hm.eventos.domain.Posicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 07-05-2017.
 */
@RepositoryRestResource(collectionResourceRel = "posicion", path = "posicion")
public interface PosicionRepository extends JpaRepository<Posicion, Integer> {
}
