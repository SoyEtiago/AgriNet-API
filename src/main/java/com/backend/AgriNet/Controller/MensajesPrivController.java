package com.backend.AgriNet.Controller;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.MensajesPrivModel;
import com.backend.AgriNet.Model.Replica;
import com.backend.AgriNet.Service.IMensajesPrivService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mensajesPriv")
public class MensajesPrivController {

    @Autowired
    private IMensajesPrivService mensajesPrivService;

    // Endpoint para guardar un nuevo mensaje privado
    @PostMapping("/nuevo")
    public ResponseEntity<String> guardarMensajePriv(@RequestBody MensajesPrivModel mensajePriv) {
        if (mensajePriv.getUsuarios() == null || mensajePriv.getUsuarios().getUserRemi() == null || mensajePriv.getUsuarios().getUserDest() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Se requieren los IDs de usuarios remitente y destinatario.");
        }
        String resultado = mensajesPrivService.guardarMensajePriv(mensajePriv);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultado);
    }

    // Endpoint para listar todos los mensajes privados
    @GetMapping("/listar")
    public ResponseEntity<List<MensajesPrivModel>> listarMensajesPriv() {
        List<MensajesPrivModel> mensajesPriv = mensajesPrivService.listarMensajesPriv();
        return ResponseEntity.status(HttpStatus.OK).body(mensajesPriv);
    }

    // Endpoint para buscar un mensaje privado por id
    @GetMapping("buscar/{id}")
    public ResponseEntity<MensajesPrivModel> buscarMensajePrivPorId(@PathVariable ObjectId id) {
        try {
            MensajesPrivModel mensajePriv = mensajesPrivService.buscarMensajePrivPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(mensajePriv);
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint para actualizar el texto de un mensaje específico dentro de `MensajesPrivModel`
    @PatchMapping("/actualizar/contenido/{idMensajePriv}")
    public ResponseEntity<String> actualizarTextoMensaje(@PathVariable ObjectId idMensajePriv, 
                                                         @RequestBody Map<String, String> contenido) {
        String textoActual = contenido.get("textoActual");
        String nuevoTexto = contenido.get("nuevoTexto");

        String resultado = mensajesPrivService.actualizarTextoMensaje(idMensajePriv, textoActual, nuevoTexto);
        if (resultado.contains("no encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resultado);
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    // Endpoint para actualizar la réplica de un mensaje privado
    @PatchMapping("/actualizar/replica/{id}")
    public ResponseEntity<String> actualizarReplica(@PathVariable ObjectId id, @RequestBody Replica nuevaReplica) {
        String resultado = mensajesPrivService.actualizarReplica(id, nuevaReplica);
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    // Endpoint para eliminar un mensaje privado por id
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarMensajePriv(@PathVariable ObjectId id) {
        String resultado = mensajesPrivService.eliminarMensajePriv(id);
        if (resultado.contains("error")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resultado);
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }
}
