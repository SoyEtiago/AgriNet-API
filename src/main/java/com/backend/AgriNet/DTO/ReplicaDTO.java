package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.TipoRecurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplicaDTO {
    private ObjectId remitente; // ID del remitente de la réplica
    private TipoRecurso tipoRecurso; // Tipo de recurso asociado a la réplica
    private String texto; // Contenido de la réplica
    private Date fechaEnvio; // Fecha de envío de la réplica
}
