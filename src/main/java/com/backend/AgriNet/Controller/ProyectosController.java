package com.backend.AgriNet.Controller;
import com.backend.AgriNet.DTO.proyectosDTO;
import com.backend.AgriNet.Model.*;
import com.backend.AgriNet.Service.IproyectosService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/Proyectos")
public class proyectosController {
    @Autowired
    IproyectosService proyectosService;

    @PostMapping("/insertar")
    public ResponseEntity <String> crearProyecto(@RequestBody ProyectosDTO proyectoDTO) {
        ObjectId creadorId = proyectoDTO.getCreadorId();
        String tipoCultivo = proyectoDTO.getTipoCultivo();
        String estado = proyectoDTO.getEstado();
        
    }
    }
