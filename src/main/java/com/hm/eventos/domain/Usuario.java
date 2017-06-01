package com.hm.eventos.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
public class Usuario {
    private int id;
    private String usuario;
    private String contrasena;
    private int edad;
    private String email;
    private String token;
    private String nivel;
    private Collection<Evento> eventos;
    private Collection<Actividad> actividades;

    @Id
    @Column(name = "Id")
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "Usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "Contrasena")
    @JsonIgnore
    public String getContrasena() {
        return contrasena;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    @Column(name = "Edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "Token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "Nivel")
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    public Collection<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Collection<Evento> eventos) {
        this.eventos = eventos;
    }


    @OneToMany(mappedBy = "usuario")
    public Collection<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Collection<Actividad> actividades) {
        this.actividades = actividades;
    }
}
