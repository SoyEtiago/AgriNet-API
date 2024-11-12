
package com.backend.AgriNet.Controller;

import com.backend.AgriNet.DTO.ActualizarCredencialesDTO;
import com.backend.AgriNet.DTO.ActualizarNombreDTO;
import com.backend.AgriNet.DTO.ActualizarReseñaDTO;
import com.backend.AgriNet.DTO.ActualizarCorreoDTO;
import com.backend.AgriNet.DTO.UsuariosDTO;
import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.*;
import com.backend.AgriNet.Service.IUsuariosService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

            if (usuarioService.buscarUsuarioPorCorreo(usuarioDTO.getEmail()) != null) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo ya está en uso.");
            }
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

    @GetMapping("/listar")
    public ResponseEntity<List<UsuariosModel>> listarUsuarios() {
        List<UsuariosModel> listaUsuarios = usuarioService.listarUsuarios();
        return ResponseEntity.status(200).body(listaUsuarios);
    }

    @GetMapping("/listar/{_id}")
    public ResponseEntity<?> listarUsuario(@PathVariable ObjectId _id) {
        try {
            UsuariosModel usuario = usuarioService.buscarUsuarioPorId(_id);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/actualizar/nombre/{_id}")
    public ResponseEntity<String> actualizarNombre(@PathVariable ObjectId _id, @RequestBody ActualizarNombreDTO nombreDTO) {
        try {
            String mensaje = usuarioService.actualizarNombre(_id, nombreDTO.getNombre());
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/actualizar/reseña/{_id}")
    public ResponseEntity<String> actualizarReseña(@PathVariable ObjectId _id, @RequestBody ActualizarReseñaDTO reseñaDTO) {
        try {
            String mensaje = usuarioService.actualizarReseña(_id, reseñaDTO.getReseña());
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/actualizar/password/{_id}")
    public ResponseEntity<String> actualizarPassword(@PathVariable ObjectId _id, @RequestBody String nuevoPassword) {
        try {
            String mensaje = usuarioService.actualizarPassword(_id, nuevoPassword);
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar/{_id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable ObjectId _id) {
        try {
            String resultado = usuarioService.eliminarUsuario(_id);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario de la base de datos.");
        }
    }
    @PatchMapping("/actualizar/correo/{_id}")
    public ResponseEntity<String> actualizarCorreo(@PathVariable ObjectId _id, @RequestBody ActualizarCorreoDTO correoDTO) {
        try {
            String mensaje = usuarioService.actualizarCorreo(_id, correoDTO.getNuevoEmail());
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/buscarPorCorreo")
    public ResponseEntity<?> buscarPorCorreo(@RequestParam String email) {
        try {
            UsuariosModel usuario = usuarioService.buscarUsuarioPorCorreo(email);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
=======
package com.backend.AgriNet.Controller;
import com.backend.AgriNet.DTO.ActualizarCredencialesDTO;
import com.backend.AgriNet.DTO.ActualizarNombreDTO;
import com.backend.AgriNet.DTO.ActualizarReseñaDTO;
import com.backend.AgriNet.DTO.UsuariosDTO;
import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.*;
import com.backend.AgriNet.Service.IUsuariosService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
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
    @GetMapping("/listar")
    public ResponseEntity<List<UsuariosModel>> listarUsuarios() {
        List<UsuariosModel> listaUsuarios = usuarioService.listarUsuarios();
        return ResponseEntity.status(200).body(listaUsuarios);
    }
    @GetMapping("/listar/{_id}")
    public ResponseEntity<?> listarUsuario(@PathVariable ObjectId _id) {
        try {
            UsuariosModel usuario = usuarioService.buscarUsuarioPorId(_id);
            return ResponseEntity.status(HttpStatus.OK).body(usuario);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PatchMapping("/actualizar/nombre/{_id}")
    public ResponseEntity<String> actualizarNombre(@PathVariable ObjectId _id, @RequestBody ActualizarNombreDTO nombreDTO) {
        try {
            String mensaje = usuarioService.actualizarNombre(_id, nombreDTO.getNombre());
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PatchMapping("/actualizar/reseña/{_id}")
    public ResponseEntity<String> actualizarReseña(@PathVariable ObjectId _id, @RequestBody ActualizarReseñaDTO reseñaDTO) {
        try {
            String mensaje = usuarioService.actualizarReseña(_id, reseñaDTO.getReseña());
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PatchMapping("/actualizar/password/{_id}")
    public ResponseEntity<String> actualizarPassword(@PathVariable ObjectId _id, @RequestBody String nuevoPassword) {
        try {
            String mensaje = usuarioService.actualizarPassword(_id, nuevoPassword);
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/eliminar/{_id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable ObjectId _id) {
        try {
            String resultado = usuarioService.eliminarUsuario(_id);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el usuario de la base de datos.");
        }
    }
}
