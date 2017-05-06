package com.hm.eventos.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
public class Registro {
    private int id;
    private String ip;
    private Timestamp fecha;
    private String actividad;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "Fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "Actividad")
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

        Registro registro = (Registro) o;

        if (id != registro.id) return false;
        if (ip != null ? !ip.equals(registro.ip) : registro.ip != null) return false;
        if (fecha != null ? !fecha.equals(registro.fecha) : registro.fecha != null) return false;
        if (actividad != null ? !actividad.equals(registro.actividad) : registro.actividad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (actividad != null ? actividad.hashCode() : 0);
        return result;
    }
}
