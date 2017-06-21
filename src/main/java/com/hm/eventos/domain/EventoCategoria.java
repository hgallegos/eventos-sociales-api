package com.hm.eventos.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
@Table(name = "evento_categoria", schema = "service_app")
public class EventoCategoria {
    private int id;
    private String nombre;
    private String descripcion;
    private Set<AsignaCategoria> asignaCategorias;

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

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<AsignaCategoria> getAsignaCategorias() {
        return asignaCategorias;
    }

    public void setAsignaCategorias(Set<AsignaCategoria> asignaCategorias) {
        this.asignaCategorias = asignaCategorias;
    }
}
