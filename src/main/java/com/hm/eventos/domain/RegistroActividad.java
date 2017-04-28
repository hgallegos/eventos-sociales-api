package com.hm.eventos.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hans6 on 27-04-2017.
 */
@Entity
@Table(name = "registro_actividad", schema = "service_app", catalog = "")
public class RegistroActividad {
    private int id;
    private int userId;
    private Timestamp fecha;
    private String actividad;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "actividad")
    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistroActividad that = (RegistroActividad) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (actividad != null ? !actividad.equals(that.actividad) : that.actividad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (actividad != null ? actividad.hashCode() : 0);
        return result;
    }
}
