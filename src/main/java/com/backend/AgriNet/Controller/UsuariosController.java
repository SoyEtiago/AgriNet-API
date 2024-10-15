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
@RequestMapping("/api/Usuarios")
public class UsuariosController {
    @Autowired
    IUsuariosService usuarioService;

    @PostMapping("/insertar")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuariosDTO usuarioDTO) {
        String nombre = usuarioDTO.getNombre();
        Direccion direccion = usuarioDTO.getDireccion();
        String foto = usuarioDTO.getFoto();
        String resena = usuarioDTO.getResena();
        String email = usuarioDTO.getEmail();
        // Validar SeguidorId, segudioId y proyectoId
    }

    // Validar seguidores
    private List<UsuariosModel> validarSeguidor(Map<String, String> seguidores) {
        List<UsuariosModel> seguidoresRecuperados = new ArrayList<>();
        for (String seguidoresInput : seguidores.values()) {
            ObjectId seguidorId = new ObjectId(seguidoresInput);
            UsuariosModel seguidor = usuarioService.buscarUsuarioPorId(seguidorId);
            if(seguidor != null) {
                seguidoresRecuperados.add(seguidor);
            }
        }
        return seguidoresRecuperados;
    }


}
