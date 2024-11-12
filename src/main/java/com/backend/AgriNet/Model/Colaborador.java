package com.backend.AgriNet.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
class Colaborador {
    private ObjectId colaboradorId;
    private String nombre;
    private String estado;

    @JsonProperty("colaboradorId")
    public String getColaboradorIdAsString() {
        return colaboradorId != null ? colaboradorId.toHexString() : null;
    }
}
