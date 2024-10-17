package com.backend.AgriNet.Model;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Proyectos")
public class proyectosModel {
    @Id
    private ObjectId _id;
    private ObjectId creadorId;
    private String tipoCultivo;
    private String estado;
    private List<Foto> fotos = new ArrayList<>();
    private List<colaborador> colaboradores = new ArrayList<>();

    
}
