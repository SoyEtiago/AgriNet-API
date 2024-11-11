package com.backend.AgriNet.Service;

import com.backend.AgriNet.Model.UsuariosModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IUsuariosService {
    String guardarUsuario(UsuariosModel usuario);
    List<UsuariosModel> listarUsuarios();
    UsuariosModel buscarUsuarioPorId(ObjectId id);

    String actualizarNombre(ObjectId id, String nuevoNombre);

    String actualizarReseña(ObjectId id, String nuevaReseña);

    String actualizarPassword(ObjectId id, String nuevoPassword);

    String eliminarUsuario(ObjectId id);
}
