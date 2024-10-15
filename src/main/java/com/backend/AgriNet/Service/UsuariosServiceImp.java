package com.backend.AgriNet.Service;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.UsuariosModel;
import com.backend.AgriNet.Repository.IUsuariosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImp implements IUsuariosService {
    @Autowired
    IUsuariosRepository usuarioRepository;

    @Override
    public String guardarUsuario(UsuariosModel usuario) {
        usuarioRepository.save(usuario);
        return String.format("El Usuario con id %s guardado exitosamente!", usuario.getIdAsString());
    }

    @Override
    public List<UsuariosModel> listarUsuarios() {
        return List.of();
    }

    @Override
    public UsuariosModel buscarUsuarioPorId(ObjectId id) {
        Optional<UsuariosModel> usuarioRecuperado = usuarioRepository.findById(id);
        return usuarioRecuperado.orElseThrow(() -> new RecursoNoEncontradoException("No existe el usuario con id " + id));
    }

    @Override
    public String eliminarUsuario(ObjectId id) {
        return "";
    }
}
