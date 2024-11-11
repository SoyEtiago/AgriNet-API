package com.backend.AgriNet.Controller;

import com.backend.AgriNet.DTO.*;
import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.*;
import com.backend.AgriNet.Service.IMensajesPrivService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/MensajesPriv")
public class MensajesPrivController {

    @Autowired
    IMensajesPrivService mensajesPrivService;

    @GetMapping()
    public ResponseEntity<String> prueba() {
        return ResponseEntity.status(HttpStatus.OK).body("Hola, API de Mensajes Privados");
    }

    @PostMapping("/insertar")
public ResponseEntity<String> crearMensajePriv(@RequestBody MensajesPrivDTO mensajesPrivDTO) {
    try {
        MensajesPrivModel mensaje = new MensajesPrivModel();

        // Configurar los usuarios remitente y destinatario desde el DTO
        Usuarios usuarios = new Usuarios();
        usuarios.setUserRemi(mensajesPrivDTO.getRemitente());
        usuarios.setUserDest(mensajesPrivDTO.getDestinatario());
        mensaje.setUsuarios(usuarios);

        // Configurar los mensajes desde el DTO
        List<Mensaje> mensajes = new ArrayList<>();
        for (MensajeDTO mensajeDTO : mensajesPrivDTO.getMensajes()) {
            Mensaje nuevoMensaje = new Mensaje();
            nuevoMensaje.setTipoRecurso(mensajeDTO.getTipoRecurso());
            nuevoMensaje.setTexto(mensajeDTO.getTexto());
            nuevoMensaje.setFechaEnvio(mensajeDTO.getFechaEnvio());
            mensajes.add(nuevoMensaje);
        }
        mensaje.setMensajes(mensajes);

        // Configurar las réplicas desde el DTO
        ReplicaDTO replicaDTO = new ReplicaDTO();
        Replica nuevaReplica = new Replica();
        nuevaReplica.setRemitente(replicaDTO.getRemitente());
        nuevaReplica.setTipoRecurso(replicaDTO.getTipoRecurso());
        nuevaReplica.setTexto(replicaDTO.getTexto());
        nuevaReplica.setFechaEnvio(replicaDTO.getFechaEnvio());
        mensaje.setReplica(nuevaReplica);

        // Guardar el mensaje usando el servicio
        String resultado = mensajesPrivService.guardarMensajePriv(mensaje);

        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    } catch (DataAccessException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el mensaje en la base de datos.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado al intentar guardar el mensaje.");
    }
}


    @GetMapping("/listar")
    public ResponseEntity<List<MensajesPrivModel>> listarMensajesPriv() {
        List<MensajesPrivModel> listaMensajes = mensajesPrivService.listarMensajesPriv();
        return ResponseEntity.status(HttpStatus.OK).body(listaMensajes);
    }

    @GetMapping("/listar/{_id}")
    public ResponseEntity<?> listarMensajePriv(@PathVariable ObjectId _id) {
        try {
            MensajesPrivModel mensaje = mensajesPrivService.buscarMensajePrivPorId(_id);
            return ResponseEntity.status(HttpStatus.OK).body(mensaje);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/actualizar/contenido/{_id}")
public ResponseEntity<String> actualizarContenido(
        @PathVariable("_id") ObjectId idMensajePriv,
        @RequestParam("textoActual") String textoActual,
        @RequestBody String nuevoContenido) {
    try {
        String mensaje = mensajesPrivService.actualizarTextoMensaje(idMensajePriv, textoActual, nuevoContenido);
        return ResponseEntity.status(HttpStatus.OK).body(mensaje);
    } catch (RecursoNoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}

    @DeleteMapping("/eliminar/{_id}")
    public ResponseEntity<String> eliminarMensajePriv(@PathVariable ObjectId _id) {
        try {
            String resultado = mensajesPrivService.eliminarMensajePriv(_id);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (DataAccessException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el mensaje de la base de datos.");
        }
    }
}
