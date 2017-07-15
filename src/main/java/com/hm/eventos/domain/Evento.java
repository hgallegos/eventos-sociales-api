package com.hm.eventos.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
public class Evento {
    private int id;
    private Usuario usuario;
    private String nombre;
    private String descripcion;
    private Date fechaRegistro;
    private Date fechaInicio;
    private Date fechaFin;
    private String visibilidad;
    private String pNombre;
    private String pDireccion;
    private double pLat;
    private double pLng;
    private String pTipo;
    private Collection<EventoFoto> eventoFotos;
    private Collection<ListaInvitado> listaInvitados;
    private Set<AsignaCategoria> asignaCategorias;
    private long facebookId;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_Id", referencedColumnName = "Id", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Column(name = "Fecha_Inicio")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "Fecha_Fin")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
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

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER, mappedBy = "evento")
    public Collection<EventoFoto> getEventoFotos() {
        return eventoFotos;
    }

    public void setEventoFotos(Collection<EventoFoto> eventoFotos) {
        this.eventoFotos = eventoFotos;
    }

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "evento")
    public Set<AsignaCategoria> getAsignaCategorias() {
        return asignaCategorias;
    }

    public void setAsignaCategorias(Set<AsignaCategoria> asignaCategorias) {
        this.asignaCategorias = asignaCategorias;
    }

    public long getFacebookId() {
        return facebookId;
    }

    @Column(name = "Facebook_Id")
    public void setFacebookId(long facebookId) {
        this.facebookId = facebookId;
    }

    @OneToMany(orphanRemoval = true, cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "evento")
    public Collection<ListaInvitado> getListaInvitados() {
        return listaInvitados;
    }

    public void setListaInvitados(Collection<ListaInvitado> listaInvitados) {
        this.listaInvitados = listaInvitados;
    }
}
