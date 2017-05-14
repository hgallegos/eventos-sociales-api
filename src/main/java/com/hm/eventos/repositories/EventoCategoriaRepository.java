package com.hm.eventos.repositories;

import com.hm.eventos.domain.EventoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 07-05-2017.
 */
@RepositoryRestResource(collectionResourceRel = "evento_categorias", path="evento_categorias")
public interface EventoCategoriaRepository extends JpaRepository<EventoCategoria, Integer> {
}
