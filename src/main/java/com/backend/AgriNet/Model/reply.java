package com.backend.AgriNet.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class reply {
    private String usuarioId;
    private Date fechaEnvio;
    private String texto;
}
