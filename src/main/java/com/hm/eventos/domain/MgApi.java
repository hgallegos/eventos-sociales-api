package com.hm.eventos.domain;

import javax.persistence.*;

/**
 * Created by hans6 on 27-04-2017.
 */
@Entity
@Table(name = "mg_api", schema = "service_app", catalog = "")
public class MgApi {
    private int id;
    private int userId;
    private String usuario;
    private String contrasena;
    private String estado;

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
    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "contrasena")
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MgApi mgApi = (MgApi) o;

        if (id != mgApi.id) return false;
        if (userId != mgApi.userId) return false;
        if (usuario != null ? !usuario.equals(mgApi.usuario) : mgApi.usuario != null) return false;
        if (contrasena != null ? !contrasena.equals(mgApi.contrasena) : mgApi.contrasena != null) return false;
        if (estado != null ? !estado.equals(mgApi.estado) : mgApi.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }
}
