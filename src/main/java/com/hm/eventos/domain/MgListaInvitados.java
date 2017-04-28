package com.hm.eventos.domain;

import javax.persistence.*;

/**
 * Created by hans6 on 27-04-2017.
 */
@Entity
@Table(name = "mg_lista_invitados", schema = "service_app", catalog = "")
public class MgListaInvitados {
    private int id;
    private int eventoId;
    private int userId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "evento_id")
    public int getEventoId() {
        return eventoId;
    }

    public void setEventoId(int eventoId) {
        this.eventoId = eventoId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MgListaInvitados that = (MgListaInvitados) o;

        if (id != that.id) return false;
        if (eventoId != that.eventoId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + eventoId;
        result = 31 * result + userId;
        return result;
    }
}
