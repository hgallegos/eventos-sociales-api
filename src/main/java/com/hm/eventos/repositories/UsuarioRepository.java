package com.hm.eventos.repositories;

import com.hm.eventos.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by hans6 on 27-04-2017.
 */
@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @RestResource(path = "email", rel = "email")
    Page<Usuario> findByEmail(@Param("email") String name, Pageable pageable);

    @RestResource(path = "usuario", rel = "usuario")
    Page<Usuario> findByUsuarioIsStartingWith(@Param("usuario") String usuario, Pageable pageable);
}
