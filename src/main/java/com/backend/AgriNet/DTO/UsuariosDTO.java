package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.Credenciales;
import com.backend.AgriNet.Model.Direccion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosDTO {
    private String nombre;
    private Direccion direccion;
    private String foto;
    private String reseña;
    private String email;
    private Credenciales credenciales;
}
