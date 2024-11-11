package com.backend.AgriNet.Controller;

import com.backend.AgriNet.DTO.MensajesPrivDTO;
import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.*;
import com.backend.AgriNet.Service.IMensajesPrivService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            mensaje.setContenido(mensajesPrivDTO.getContenido());
            mensaje.setRemitente(mensajesPrivDTO.getRemitente());
            mensaje.setDestinatario(mensajesPrivDTO.getDestinatario());
            mensaje.setFechaEnvio(mensajesPrivDTO.getFechaEnvio());
            mensaje.setRecursos(mensajesPrivDTO.getRecursos());
            mensaje.setReplicas(mensajesPrivDTO.getReplicas());

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
    public ResponseEntity<String> actualizarContenido(@PathVariable ObjectId _id, @RequestBody String nuevoContenido) {
        try {
            String mensaje = mensajesPrivService.actualizarContenido(_id, nuevoContenido);
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
