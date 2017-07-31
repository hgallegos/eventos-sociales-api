package com.hm.eventos.services.impl;

import com.hm.eventos.domain.Actividad;
import com.hm.eventos.repositories.ActividadRepository;
import com.hm.eventos.services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hans6 on 31-07-2017.
 */
@Service
public class ActividadServiceImpl implements ActividadService {

    @Autowired
    private ActividadRepository actividadRepository;

    @Override
    public Actividad saveActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }
}
