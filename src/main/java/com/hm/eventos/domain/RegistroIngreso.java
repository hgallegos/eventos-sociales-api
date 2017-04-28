package com.hm.eventos.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hans6 on 27-04-2017.
 */
@Entity
@Table(name = "registro_ingreso", schema = "service_app", catalog = "")
public class RegistroIngreso {
    private int id;
    private int userId;
    private Timestamp fecha;
    private String ip;
    private String aplicacion;

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
    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Basic
    @Column(name = "aplicacion")
    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistroIngreso that = (RegistroIngreso) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (ip != null ? !ip.equals(that.ip) : that.ip != null) return false;
        if (aplicacion != null ? !aplicacion.equals(that.aplicacion) : that.aplicacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (ip != null ? ip.hashCode() : 0);
        result = 31 * result + (aplicacion != null ? aplicacion.hashCode() : 0);
        return result;
    }
}
