package com.backend.AgriNet.Service;

import com.backend.AgriNet.Model.UsuariosModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IUsuariosService {
    public String guardarUsuario(UsuariosModel usuario);
    public List<UsuariosModel> listarUsuarios();
    public UsuariosModel buscarUsuarioPorId(ObjectId id);

    String actualizarNombre(ObjectId id, String nuevoNombre);

    String actualizarReseña(ObjectId id, String nuevaReseña);

    String actualizarPassword(ObjectId id, String nuevoPassword);

    public String eliminarUsuario(ObjectId id);
}
