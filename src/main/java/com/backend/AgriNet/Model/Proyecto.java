package com.backend.AgriNet.Model;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Proyectos")
public class Proyecto {
    @Id
    private ObjectId id;
    private ObjectId creadorId;
    private String tipoCultivo;
    private String estado;
    private List<String> fotos;
    private List<Colaborador> colaboradores;

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }
    @JsonProperty("creadorId")
    public String getCreadorIdAsString() {
        return creadorId != null ? creadorId.toHexString() : null;
    }
}

    

