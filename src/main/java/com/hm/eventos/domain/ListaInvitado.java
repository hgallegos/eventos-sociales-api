package com.hm.eventos.domain;

import javax.persistence.*;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
@Table(name = "lista_invitado", schema = "service_app", catalog = "")
public class ListaInvitado {
    private int id;
    private Evento evento;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListaInvitado that = (ListaInvitado) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "Evento_Id", referencedColumnName = "Id", nullable = false)
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
