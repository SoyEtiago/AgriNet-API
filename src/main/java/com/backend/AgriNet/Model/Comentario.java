package com.backend.AgriNet.Model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Comentarios")
public class Comentario {
    @Id
    private ObjectId id;
    private ObjectId proyectoId;
    private ObjectId usuarioId;
    private String texto;
    private Date fechaEnvio;
    private reply reply;

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }
    @JsonProperty("proyectoId")
    public String getProyectoIdAsString() {
        return proyectoId != null ? proyectoId.toHexString() : null;
    }
    @JsonProperty("usuarioId")
    public String getUsuarioIdAsString() {
        return usuarioId != null ? usuarioId.toHexString() : null;
    }
}
