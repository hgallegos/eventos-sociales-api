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
public class Posicion {
    private int id;
    private Timestamp fecha;
    private String nombre;
    private String direccion;
    private double lat;
    private double lng;
    private String tipo;
    private int defecto;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "Lat")
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "Lng")
    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Basic
    @Column(name = "Tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "Defecto")
    public int getDefecto() {
        return defecto;
    }

    public void setDefecto(int defecto) {
        this.defecto = defecto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Posicion posicion = (Posicion) o;

        if (id != posicion.id) return false;
        if (Double.compare(posicion.lat, lat) != 0) return false;
        if (Double.compare(posicion.lng, lng) != 0) return false;
        if (defecto != posicion.defecto) return false;
        if (fecha != null ? !fecha.equals(posicion.fecha) : posicion.fecha != null) return false;
        if (nombre != null ? !nombre.equals(posicion.nombre) : posicion.nombre != null) return false;
        if (direccion != null ? !direccion.equals(posicion.direccion) : posicion.direccion != null) return false;
        if (tipo != null ? !tipo.equals(posicion.tipo) : posicion.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        temp = Double.doubleToLongBits(lat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + defecto;
        return result;
    }
}
