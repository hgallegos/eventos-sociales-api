package com.hm.eventos.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
public class Api {
    private int id;
    private String usuario;
    private String contrasena;
    private String estado;
    private Collection<Registro> registros;

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
    @Column(name = "Estado")
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

        Api api = (Api) o;

        if (id != api.id) return false;
        if (usuario != null ? !usuario.equals(api.usuario) : api.usuario != null) return false;
        if (contrasena != null ? !contrasena.equals(api.contrasena) : api.contrasena != null) return false;
        if (estado != null ? !estado.equals(api.estado) : api.estado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (contrasena != null ? contrasena.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "api")
    public Collection<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(Collection<Registro> registros) {
        this.registros = registros;
    }
}
