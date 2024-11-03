package com.backend.AgriNet.Controller;

import com.backend.AgriNet.DTO.UsuariosDTO;
import com.backend.AgriNet.Model.*;
import com.backend.AgriNet.Service.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuariosController {
    @Autowired
    IUsuariosService usuarioService;

    @GetMapping()
    public ResponseEntity<String> prueba() {
        return ResponseEntity.status(200).body("Hola, API");
    }

    @PostMapping("/insertar")
    public ResponseEntity<String> crearUsuario(@RequestBody UsuariosDTO usuarioDTO) {
        try {
            UsuariosModel usuario = new UsuariosModel();
            usuario.setNombre(usuarioDTO.getNombre());
            usuario.setDireccion(usuarioDTO.getDireccion());
            usuario.setFoto(usuarioDTO.getFoto());
            usuario.setReseña(usuarioDTO.getReseña());
            usuario.setEmail(usuarioDTO.getEmail());
            usuario.setCredenciales(usuarioDTO.getCredenciales());

            String resultado = usuarioService.guardarUsuario(usuario);

            return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el usuario en la base de datos.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado al intentar guardar el usuario.");
        }
    }
}
