package com.hm.eventos.repositories;

import com.hm.eventos.domain.AsignaCategoria;
import com.hm.eventos.domain.Evento;
import com.hm.eventos.domain.EventoCategoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.awt.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by hans6 on 27-04-2017.
 */
@RepositoryRestResource(collectionResourceRel = "eventos", path = "eventos")
public interface EventoRepository extends JpaRepository<Evento, Integer> {

    @RestResource(rel = "filterBy", path = "filterBy")
    @Query(value = "select * from evento where Nombre like %:nombre% and P_Direccion like %:direccion% and id = " +
            "(select Id_Evento from (asigna_categoria join evento_categoria) where :categoria = evento_categoria.Id)" +
            "order by ?#{#pageable}",
            countQuery = "select count(*) from evento where Nombre like %:nombre% and P_Direccion like %:direccion% and id = " +
                    "(select Id_Evento from (asigna_categoria join evento_categoria) where :categoria = evento_categoria.Id)",
            nativeQuery = true)
    Page<Evento> findAllBy(@Param("nombre") String nombre, @Param("direccion") String direccion, @Param("categoria") int categoria, Pageable pageable);

    @RestResource(rel = "nombreODireccion", path = "nombreODireccion")
    Page<Evento> findAllByNombreContainingIgnoreCaseAndPDireccionContainingIgnoreCase(
            @Param("nombre") String nombre, @Param("direccion") String direccion, Pageable pageable);

    Evento findByFacebookId(long id);


}
