package com.backend.AgriNet.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direccion {
    private String barrio;
    private String codigoPostal;
    private String ciudad;
    private String departamento;
}
