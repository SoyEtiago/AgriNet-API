package com.backend.AgriNet.Service;

import com.backend.AgriNet.Model.UsuariosModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IUsuariosService {
    public String guardarUsuario(UsuariosModel usuario);
    public List<UsuariosModel> listarUsuarios();
    public UsuariosModel buscarUsuarioPorId(ObjectId id);
    public String eliminarUsuario(ObjectId id);
}
