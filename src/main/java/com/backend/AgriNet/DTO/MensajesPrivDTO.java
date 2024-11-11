package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.Recurso;
import com.backend.AgriNet.Model.Replica;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensajesPrivDTO {
    private String contenido;
    private ObjectId remitente;
    private ObjectId destinatario;
    private Date fechaEnvio;
    private List<Recurso> recursos;
    private List<Replica> replicas;
}
