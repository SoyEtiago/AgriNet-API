package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.fotos;
import com.backend.AgriNet.Model.colaboradores;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProyectosDTO {
    private ObjectId creadorId;    
    private String tipoCultivo;   
    private String estado;   
    private Map<String, String> foto;   
    private Map<String, String> colaboradores;   

}
