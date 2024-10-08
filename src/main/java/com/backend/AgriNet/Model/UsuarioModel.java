package com.backend.AgriNet.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Usuarios")
public class UsuarioModel {
    @Id
    private ObjectId id;
    private String nombre;
    private Direccion direccion;
    private String foto;
    private String reseña;
    private String email;
    private Credenciales credenciales;
    private List<Seguidor> seguidores = new ArrayList<>();
    private List<Seguido> seguidos = new ArrayList<>();
    private List<ObjectId> colaboraciones = new ArrayList<>();
}
