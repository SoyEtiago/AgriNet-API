package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.Replica;
import com.backend.AgriNet.Model.Usuarios;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MensajesPrivDTO {
    private ObjectId remitente; // ID del usuario remitente
    private ObjectId destinatario; // ID del usuario destinatario
    private List<MensajeDTO> mensajes = new ArrayList<>(); // Lista de mensajes
    private Replica replica; // Lista de réplicas
}
