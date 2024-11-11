package com.backend.AgriNet.Service;

import com.backend.AgriNet.Model.MensajesPrivModel;
import com.backend.AgriNet.Model.Replica;
import org.bson.types.ObjectId;

import java.util.List;

public interface IMensajesPrivService {
    String guardarMensajePriv(MensajesPrivModel mensajePriv);
    List<MensajesPrivModel> listarMensajesPriv();
    MensajesPrivModel buscarMensajePrivPorId(ObjectId id);
    String actualizarTextoMensaje(ObjectId id, String textoActual, String nuevoTexto);
    String actualizarReplica(ObjectId id, Replica nuevaReplica);
    String eliminarMensajePriv(ObjectId id);
}
