package com.hm.eventos.domain.projections;

import com.hm.eventos.domain.AsignaCategoria;
import com.hm.eventos.domain.Evento;
import com.hm.eventos.domain.EventoFoto;
import com.hm.eventos.domain.Usuario;
import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by hans6 on 11-07-2017.
 */
@Projection(name = "fotos", types = {Evento.class})
public interface EventoProjection {

    String getNombre();

    String getDescripcion();

    Date getFechaRegistro();

    Date getFechaInicio();

    Date getFechaFin();

    String getVisibilidad();

    String getpNombre();

    String getpDireccion();

    double getpLat();

    double getpLng();

    String getpTipo();

    Collection<EventoFoto> getEventoFotos();

    Set<AsignaCategoria> getAsignaCategorias();

    long getFacebookId();
}
