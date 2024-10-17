package com.backend.AgriNet.Model;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "comentarios")
public class ComentariosModel {

    @Id

    private ObjectId _id;
    private ObjectId comentarioId;
    private ObjectId proyectoId;
    private ObjectId usuarioId;
    private String texto;
    private String recursoMultimedia;
    private Date fechaEnvio;   
}