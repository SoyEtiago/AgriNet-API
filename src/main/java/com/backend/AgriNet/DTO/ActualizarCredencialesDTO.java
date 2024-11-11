package com.backend.AgriNet.DTO;

import com.backend.AgriNet.Model.Credenciales;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActualizarCredencialesDTO {
    private Credenciales credenciales;
}
