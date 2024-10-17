package com.backend.AgriNet.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class colaboradores {
    private ObjectId colaboradorId;
    private String nombre;
}