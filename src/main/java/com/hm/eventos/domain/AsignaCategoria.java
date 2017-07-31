package com.hm.eventos.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * Created by hans6 on 08-06-2017.
 */
@Entity(name = "asignaCategoria")
@Table(name = "asigna_categoria")
public class AsignaCategoria {

    private int id;
    private Evento evento;
    private EventoCategoria categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Evento", referencedColumnName = "Id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @ManyToOne
    @JoinColumn(name = "Id_Categoria", referencedColumnName = "Id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public EventoCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(EventoCategoria categoria) {
        this.categoria = categoria;
    }
}
