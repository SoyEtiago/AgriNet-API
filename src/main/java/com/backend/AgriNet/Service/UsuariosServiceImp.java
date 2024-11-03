package com.backend.AgriNet.Service;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.UsuariosModel;
import com.backend.AgriNet.Repository.IUsuariosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImp implements IUsuariosService {
    @Autowired
    IUsuariosRepository usuarioRepository;

    @Override
    public String guardarUsuario(UsuariosModel usuario) {
        try {
            usuarioRepository.save(usuario);
            return String.format("El usuario con id %s fue creado exitosamente!", usuario.getIdAsString());
        } catch (DataAccessException e) {
            // Manejo de excepciones relacionadas con el acceso a datos
            return "Ocurrió un error al guardar el usuario en la base de datos." + e.getMessage();
        } catch (Exception e) {
            // Manejo de cualquier otra excepción inesperada
            return "Ocurrió un error inesperado al intentar guardar el usuario." + e.getMessage();
        }
    }

    @Override
    public List<UsuariosModel> listarUsuarios() {
        return usuarioRepository.findAll();
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
