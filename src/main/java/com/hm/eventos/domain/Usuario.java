package com.hm.eventos.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
public class Usuario {
    private int id;
    private String usuario;
    private String contrasena;
    private String nombre;
    private int edad;
    private String email;
    private String token;
    private String nivel;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "Contrasena")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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
    @Column(name = "Edad")
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "Nivel")
    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario1 = (Usuario) o;

        if (id != usuario1.id) return false;
        if (edad != usuario1.edad) return false;
        if (usuario != null ? !usuario.equals(usuario1.usuario) : usuario1.usuario != null) return false;
        if (contrasena != null ? !contrasena.equals(usuario1.contrasena) : usuario1.contrasena != null) return false;
        if (nombre != null ? !nombre.equals(usuario1.nombre) : usuario1.nombre != null) return false;
        if (email != null ? !email.equals(usuario1.email) : usuario1.email != null) return false;
        if (token != null ? !token.equals(usuario1.token) : usuario1.token != null) return false;
        if (nivel != null ? !nivel.equals(usuario1.nivel) : usuario1.nivel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + edad;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (nivel != null ? nivel.hashCode() : 0);
        return result;
    }
}
