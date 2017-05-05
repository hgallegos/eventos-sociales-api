package com.hm.eventos.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Set;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
public class Evento {
    private int id;
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
    private Set<EventoFoto> eventoFotosById;
    private Set<ListaInvitado> listaInvitadosById;
    private Collection<EventoFoto> fotos;
    private Collection<ListaInvitado> invitados;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Fecha_Registro")
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Basic
    @Column(name = "Fecha_Inicio")
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Basic
    @Column(name = "Fecha_Fin")
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Basic
    @Column(name = "Visibilidad")
    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    @Basic
    @Column(name = "P_Nombre")
    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    @Basic
    @Column(name = "P_Direccion")
    public String getpDireccion() {
        return pDireccion;
    }

    public void setpDireccion(String pDireccion) {
        this.pDireccion = pDireccion;
    }

    @Basic
    @Column(name = "P_Lat")
    public double getpLat() {
        return pLat;
    }

    public void setpLat(double pLat) {
        this.pLat = pLat;
    }

    @Basic
    @Column(name = "P_Lng")
    public double getpLng() {
        return pLng;
    }

    public void setpLng(double pLng) {
        this.pLng = pLng;
    }

    @Basic
    @Column(name = "P_Tipo")
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

        Evento evento = (Evento) o;

        if (id != evento.id) return false;
        if (Double.compare(evento.pLat, pLat) != 0) return false;
        if (Double.compare(evento.pLng, pLng) != 0) return false;
        if (nombre != null ? !nombre.equals(evento.nombre) : evento.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(evento.descripcion) : evento.descripcion != null) return false;
        if (fechaRegistro != null ? !fechaRegistro.equals(evento.fechaRegistro) : evento.fechaRegistro != null)
            return false;
        if (fechaInicio != null ? !fechaInicio.equals(evento.fechaInicio) : evento.fechaInicio != null) return false;
        if (fechaFin != null ? !fechaFin.equals(evento.fechaFin) : evento.fechaFin != null) return false;
        if (visibilidad != null ? !visibilidad.equals(evento.visibilidad) : evento.visibilidad != null) return false;
        if (pNombre != null ? !pNombre.equals(evento.pNombre) : evento.pNombre != null) return false;
        if (pDireccion != null ? !pDireccion.equals(evento.pDireccion) : evento.pDireccion != null) return false;
        if (pTipo != null ? !pTipo.equals(evento.pTipo) : evento.pTipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
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

    @OneToMany(mappedBy = "evento")
    public Collection<EventoFoto> getFotos() {
        return fotos;
    }

    public void setFotos(Collection<EventoFoto> fotos) {
        this.fotos = fotos;
    }

    @OneToMany(mappedBy = "evento")
    public Collection<ListaInvitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(Collection<ListaInvitado> invitados) {
        this.invitados = invitados;
    }
}
