package com.backend.AgriNet.Controller;

import com.backend.AgriNet.DTO.UsuariosDTO;
import com.backend.AgriNet.Model.*;
import com.backend.AgriNet.Service.IUsuariosService;
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
public class ProyectosController {
    @Autowired
    IProyectosService ProyectosService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearProyecto(@RequestBody ProyectosDTO proyectosDTO){
        ObjectId creadorId = proyectosDTO.getId();
        String tipoCultivo = proyectosDTO.getCultivo();
        String estado = proyectosDTO.getEstado();
    }

}
