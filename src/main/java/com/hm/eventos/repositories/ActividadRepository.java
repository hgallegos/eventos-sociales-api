package com.hm.eventos.repositories;

import com.hm.eventos.domain.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 13-05-2017.
 */
@RepositoryRestResource(collectionResourceRel = "actividades", path = "actividades")
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {
}
