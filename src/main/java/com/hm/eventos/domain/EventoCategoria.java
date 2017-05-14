package com.hm.eventos.domain;

import javax.persistence.*;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
@Table(name = "evento_categoria", schema = "service_app", catalog = "")
public class EventoCategoria {
    private int id;
    private String nombre;
    private String descripcion;

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

}
