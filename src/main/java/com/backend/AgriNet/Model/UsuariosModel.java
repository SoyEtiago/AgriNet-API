package com.backend.AgriNet.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosModel {
    @Id
    @JsonIgnore
    private ObjectId _id;
    private String nombre;
    private Direccion direccion;
    private String foto;
    private String reseña;
    private String email;
    private Credenciales credenciales;
    private List<Seguidor> seguidores = new ArrayList<>();
    private List<Seguido> seguidos = new ArrayList<>();
    private List<Colaboracion> colaboraciones = new ArrayList<>();

    @JsonProperty("_id")
    public String getIdAsString() {
        return _id != null ? _id.toHexString() : null;
    }
}