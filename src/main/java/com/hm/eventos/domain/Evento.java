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
    private Collection<EventoFoto> eventoFotos;
    private Set<ListaInvitado> listaInvitados;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "Descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Column(name = "Fecha_Registro")
    public Timestamp getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Timestamp fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Column(name = "Fecha_Inicio")
    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "Fecha_Fin")
    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Column(name = "Visibilidad")
    public String getVisibilidad() {
        return visibilidad;
    }

    public void setVisibilidad(String visibilidad) {
        this.visibilidad = visibilidad;
    }

    @Column(name = "P_Nombre")
    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    @Column(name = "P_Direccion")
    public String getpDireccion() {
        return pDireccion;
    }

    public void setpDireccion(String pDireccion) {
        this.pDireccion = pDireccion;
    }

    @Column(name = "P_Lat")
    public double getpLat() {
        return pLat;
    }

    public void setpLat(double pLat) {
        this.pLat = pLat;
    }

    @Column(name = "P_Lng")
    public double getpLng() {
        return pLng;
    }

    public void setpLng(double pLng) {
        this.pLng = pLng;
    }

    @Column(name = "P_Tipo")
    public String getpTipo() {
        return pTipo;
    }

    public void setpTipo(String pTipo) {
        this.pTipo = pTipo;
    }

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY,mappedBy = "evento")
    public Collection<EventoFoto> getListaFotos() {
        return eventoFotos;
    }

    public void setListaFotos(Collection<EventoFoto> eventoFotos) {
        this.eventoFotos = eventoFotos;
    }

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "evento")
    public Set<ListaInvitado> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(Set<ListaInvitado> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }

}
