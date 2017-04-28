package com.hm.eventos.repositories;

import com.hm.eventos.domain.MgApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by hans6 on 27-04-2017.
 */
@RepositoryRestResource(collectionResourceRel = "api", path = "api")
public interface ApiRepository extends JpaRepository<MgApi, Integer> {

}
