package com.hm.eventos.domain.projections;

import com.hm.eventos.domain.Actividad;
import com.hm.eventos.domain.Evento;
import com.hm.eventos.domain.Usuario;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;

/**
 * Created by hans6 on 13-05-2017.
 */
@Projection(name = "actividadesYEventos", types = {Usuario.class})
public interface UsuarioProjection {


    String getUsuario();

    String getEmail();

    int getEdad();

    String getToken();

    String getNivel();

    Collection<Actividad> getActividades();

    Collection<Evento> getEventos();
}
