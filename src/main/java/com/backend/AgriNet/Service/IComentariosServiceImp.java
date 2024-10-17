package com.backend.AgriNet.Service;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.ComentariosModel;
import com.backend.AgriNet.Repository.IComentariosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentariosServiceImp implements IComentariosService {
    @Autowired
    IComentariosRepository ComentariosRepository;

    @Override
    public String guardarComentario(ComentarioModel comentario) {
        comentarioRepository.save(comentario);
        return String.format("el comentario con id %s ha sido publicada exitosamente!", comentario.getIdAsString());
    }

    @Override
    public List<ComentarioModel> listarComentarios() {
        return List.of();
    }

    @Override
    public ComentarioModel buscarComentarioPorId(ObjectId id) {
        Optional<ComentarioModel> comentarioRecuperada = comentarioRepository.findById(id);
        return comentarioRecuperada.orElseThrow(() -> new RecursoNoEncontradoException("No existe el comentario con id " + id));
    }

    @Override
    public String eliminarcomentario(ObjectId id) {
        return ""
    }
}

