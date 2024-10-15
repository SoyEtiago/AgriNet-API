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
    private ObjectId id;
    private String nombre;
    private Direccion direccion;
    private String foto;
    private String resena;
    private String email;
    private Credenciales credenciales;
    private List<Seguidor> seguidores = new ArrayList<>();
    private List<Seguido> seguidos = new ArrayList<>();
    private List<ObjectId> colaboraciones = new ArrayList<>();

    @JsonProperty("id")
    public String getIdAsString() {
        return id != null ? id.toHexString() : null;
    }
}