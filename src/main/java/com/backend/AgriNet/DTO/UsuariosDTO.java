package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.Credenciales;
import com.backend.AgriNet.Model.Direccion;
import com.backend.AgriNet.Model.Seguido;
import com.backend.AgriNet.Model.Seguidor;
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
public class UsuariosDTO {
    private String nombre;
    private Direccion direccion;
    private String foto;
    private String resena;
    private String email;
    private Credenciales credenciales;
    private Map<String, String> seguidores;
    private Map<String, String> seguidos;
    private Map<String, String> colaboraciones;
}
