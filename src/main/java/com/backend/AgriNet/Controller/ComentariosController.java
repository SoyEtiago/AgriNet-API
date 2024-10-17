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
@RequestMapping("/api/Comentarios")
public class ComentariosController {
    @Autowired
    IComentariosService ComentariosService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearComentario(@RequestBody ComentariosDTO comentarioDTO){
        ObjectId comentarioId = comentarioDTO.getComentarioId();
        ObjectId proyectoId = comentarioDTO.getProyectoId();
        ObjectId usuarioId = comentarioDTO.getUsuarioId();
        String texto = comentarioDTO.getTexto();
        String recursoMultimedia = comentarioDTO.getRecursoMultimedia();
        Date fechaEnvio = comentarioDTO.getFechaEnvio();
    }
}


