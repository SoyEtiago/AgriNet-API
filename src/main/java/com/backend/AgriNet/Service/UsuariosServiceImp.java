package com.backend.AgriNet.Service;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.*;
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
    public String actualizarNombre(ObjectId id, String nuevoNombre) {
        UsuariosModel usuario = buscarUsuarioPorId(id);
        usuario.setNombre(nuevoNombre);
        usuarioRepository.save(usuario);
        return String.format("El nombre del usuario con id %s ha sido actualizado exitosamente.", id);
    }

    @Override
    public String actualizarReseña(ObjectId id, String nuevaReseña) {
        UsuariosModel usuario = buscarUsuarioPorId(id);
        usuario.setReseña(nuevaReseña);
        usuarioRepository.save(usuario);
        return String.format("La reseña del usuario con id %s ha sido actualizada exitosamente.", id);
    }

    @Override
    public String actualizarPassword(ObjectId id, String nuevoPassword) {
        UsuariosModel usuario = buscarUsuarioPorId(id);
        Credenciales credenciales = usuario.getCredenciales();

        // Verificar si la nueva contraseña ya ha sido utilizada previamente
        for (Password password : credenciales.getPasswords()) {
            if (password.getPassContent().equals(nuevoPassword)) {
                return "La contraseña ya ha sido utilizada anteriormente. Por favor, elija una contraseña diferente.";
            }
        }

        // Cambiar estado de todas las contraseñas a "Inactiva"
        credenciales.getPasswords().forEach(password -> password.setEstado(Estado.Inactiva.name()));

        // Añadir la nueva contraseña con estado "Activa"
        Password nuevaPassword = new Password(nuevoPassword, Estado.Activa.name());
        credenciales.getPasswords().add(nuevaPassword);

        usuarioRepository.save(usuario);
        return String.format("La contraseña del usuario con id %s ha sido actualizada exitosamente.", id);
    }

    @Override
    public String eliminarUsuario(ObjectId id) {
        try {
            UsuariosModel usuario = buscarUsuarioPorId(id);
            usuarioRepository.delete(usuario);
            return String.format("El usuario con id %s fue eliminado exitosamente!", id);
        } catch (DataAccessException e) {
            return "Ocurrió un error al intentar eliminar el usuario: " + e.getMessage();
        }
    }
}
