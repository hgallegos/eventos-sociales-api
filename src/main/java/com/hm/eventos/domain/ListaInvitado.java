package com.hm.eventos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by hans6 on 05-05-2017.
 */
@Entity
@Table(name = "lista_invitado", schema = "service_app")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ListaInvitado {
    private int id;
    private Evento evento;
    private Usuario usuario;

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "Evento_Id", referencedColumnName = "Id", nullable = false)
    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @ManyToOne
    @JoinColumn(name = "User_Id", referencedColumnName = "Id", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
