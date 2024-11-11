package com.backend.AgriNet.Service;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.MensajesPrivModel;
import com.backend.AgriNet.Model.Mensaje;
import com.backend.AgriNet.Model.Replica;
import com.backend.AgriNet.Model.TipoRecurso;
import com.backend.AgriNet.Model.Usuarios;
import com.backend.AgriNet.Model.Recurso;
import com.backend.AgriNet.Repository.IMensajesPrivRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajesPrivServiceImp implements IMensajesPrivService {

    @Autowired
    private IMensajesPrivRepository mensajePrivRepository;

    @Override
    public String guardarMensajePriv(MensajesPrivModel mensajePriv) {
        try {
            mensajePrivRepository.save(mensajePriv);
            return String.format("El mensaje privado con id %s fue creado exitosamente!", mensajePriv.getIdAsString());
        } catch (DataAccessException e) {
            return "Ocurrió un error al guardar el mensaje en la base de datos." + e.getMessage();
        } catch (Exception e) {
            return "Ocurrió un error inesperado al intentar guardar el mensaje." + e.getMessage();
        }
    }

    @Override
    public List<MensajesPrivModel> listarMensajesPriv() {
        return mensajePrivRepository.findAll();
    }

    @Override
    public MensajesPrivModel buscarMensajePrivPorId(ObjectId id) {
        Optional<MensajesPrivModel> mensajeRecuperado = mensajePrivRepository.findById(id);
        return mensajeRecuperado.orElseThrow(() -> new RecursoNoEncontradoException("No existe el mensaje privado con id " + id));
    }

    @Override
    public String actualizarTextoMensaje(ObjectId id, int index, String nuevoTexto) {
        MensajesPrivModel mensajePriv = buscarMensajePrivPorId(id);

        if (index >= 0 && index < mensajePriv.getMensajes().size()) {
            mensajePriv.getMensajes().get(index).setTexto(nuevoTexto);
            mensajePrivRepository.save(mensajePriv);
            return String.format("El texto del mensaje en la posición %d del mensaje privado con id %s ha sido actualizado exitosamente.", index, id);
        } else {
            return String.format("Índice %d fuera de rango para el mensaje privado con id %s.", index, id);
        }
    }

    @Override
    public String actualizarReplica(ObjectId id, MensajesPrivModel.Replica nuevaReplica) {
        MensajesPrivModel mensajePriv = buscarMensajePrivPorId(id);
        mensajePriv.setReplica(nuevaReplica);
        mensajePrivRepository.save(mensajePriv);
        return String.format("La réplica del mensaje privado con id %s ha sido actualizada exitosamente.", id);
    }

    @Override
    public String eliminarMensajePriv(ObjectId id) {
        try {
            MensajesPrivModel mensajePriv = buscarMensajePrivPorId(id);
            mensajePrivRepository.delete(mensajePriv);
            return String.format("El mensaje privado con id %s fue eliminado exitosamente!", id);
        } catch (DataAccessException e) {
            return "Ocurrió un error al intentar eliminar el mensaje privado: " + e.getMessage();
        }
    }
}
