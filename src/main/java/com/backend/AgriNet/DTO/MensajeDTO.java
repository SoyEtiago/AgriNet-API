package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.TipoRecurso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensajeDTO {
    private TipoRecurso tipoRecurso; // Tipo de recurso (PDF, Multimedia, etc.)
    private String texto; // Contenido del mensaje
    private Date fechaEnvio; // Fecha de envío del mensaje
}
