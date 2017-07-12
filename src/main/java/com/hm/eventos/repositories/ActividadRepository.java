package com.hm.eventos.repositories;

import com.hm.eventos.domain.Actividad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.time.Month;
import java.util.Date;

/**
 * Created by hans6 on 13-05-2017.
 */
@RepositoryRestResource(collectionResourceRel = "actividades", path = "actividades")
public interface ActividadRepository extends JpaRepository<Actividad, Integer> {

    Page<Actividad> findAllByTipo(@Param("tipo") String tipo, Pageable pageable);

    Page<Actividad> findAllByTipoAndFechaBetween(@Param("tipo") String tipo, @Param("start")Date start, @Param("end") Date end, Pageable pageable);
}
