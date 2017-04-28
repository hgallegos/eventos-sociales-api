package com.hm.eventos.domain;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hans6 on 27-04-2017.
 */
@Entity
@Table(name = "mg_eventos", schema = "service_app", catalog = "")
public class MgEventos {
    private int id;
    private int userId;
    private int categoriaId;
    private String nombre;
    private String descripcion;
    private Timestamp fechaRegistro;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private String visibilidad;
    private String pNombre;
    private String pDireccion;
    private double pLat;
    private double pLng;
    private String pTipo;

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
    @Column(name = "categoria_id")
    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "fecha_registro")
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Basic
    @Column(name = "fecha_inicio")
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "fecha_fin")
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "visibilidad")
    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    @Basic
    @Column(name = "p_nombre")
    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    @Basic
    @Column(name = "p_direccion")
    public String getpDireccion() {
        return pDireccion;
    }

    public void setpDireccion(String pDireccion) {
        this.pDireccion = pDireccion;
    }

    @Basic
    @Column(name = "p_lat")
    public double getpLat() {
        return pLat;
    }

    public void setpLat(double pLat) {
        this.pLat = pLat;
    }

    @Basic
    @Column(name = "p_lng")
    public double getpLng() {
        return pLng;
    }

    public void setpLng(double pLng) {
        this.pLng = pLng;
    }

    @Basic
    @Column(name = "p_tipo")
    public String getpTipo() {
        return pTipo;
    }

    public void setpTipo(String pTipo) {
        this.pTipo = pTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MgEventos mgEventos = (MgEventos) o;

        if (id != mgEventos.id) return false;
        if (userId != mgEventos.userId) return false;
        if (categoriaId != mgEventos.categoriaId) return false;
        if (Double.compare(mgEventos.pLat, pLat) != 0) return false;
        if (Double.compare(mgEventos.pLng, pLng) != 0) return false;
        if (nombre != null ? !nombre.equals(mgEventos.nombre) : mgEventos.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(mgEventos.descripcion) : mgEventos.descripcion != null)
            return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(mgEventos.fechaRegistro) : mgEventos.fechaRegistro != null)
            return false;
        if (fechaInicio != null ? !fechaInicio.equals(mgEventos.fechaInicio) : mgEventos.fechaInicio != null)
            return false;
        if (fechaFin != null ? !fechaFin.equals(mgEventos.fechaFin) : mgEventos.fechaFin != null) return false;
        if (visibilidad != null ? !visibilidad.equals(mgEventos.visibilidad) : mgEventos.visibilidad != null)
            return false;
        if (pNombre != null ? !pNombre.equals(mgEventos.pNombre) : mgEventos.pNombre != null) return false;
        if (pDireccion != null ? !pDireccion.equals(mgEventos.pDireccion) : mgEventos.pDireccion != null) return false;
        if (pTipo != null ? !pTipo.equals(mgEventos.pTipo) : mgEventos.pTipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + userId;
        result = 31 * result + categoriaId;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (fechaRegistro != null ? fechaRegistro.hashCode() : 0);
        result = 31 * result + (fechaInicio != null ? fechaInicio.hashCode() : 0);
        result = 31 * result + (fechaFin != null ? fechaFin.hashCode() : 0);
        result = 31 * result + (visibilidad != null ? visibilidad.hashCode() : 0);
        result = 31 * result + (pNombre != null ? pNombre.hashCode() : 0);
        result = 31 * result + (pDireccion != null ? pDireccion.hashCode() : 0);
        temp = Double.doubleToLongBits(pLat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pLng);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (pTipo != null ? pTipo.hashCode() : 0);
        return result;
    }
}
