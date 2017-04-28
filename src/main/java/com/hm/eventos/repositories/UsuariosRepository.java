package com.hm.eventos.repositories;

import com.hm.eventos.domain.MgUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 27-04-2017.
 */
@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuariosRepository extends JpaRepository<MgUsuarios, Integer> {
}
