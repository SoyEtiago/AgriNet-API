package com.backend.AgriNet.Model;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Comentarios")
public class Comentario {
    @Id
    private String id;
    private String proyectoId;
    private String usuarioId;
    private String texto;
    private Date fechaEnvio;
    private reply reply;
    private String tipoRecurso;
    private String tipoDato;
    private String recurso;

    // Getters y Setters

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public reply getReply() {
        return reply;
    }

    public void setReply(reply reply) {
        this.reply = reply;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }
}
