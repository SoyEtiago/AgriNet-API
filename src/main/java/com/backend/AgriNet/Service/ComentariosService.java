package com.backend.AgriNet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.AgriNet.Model.Comentario;
import com.backend.AgriNet.Repository.IComentariosRepository;

@Service
public class ComentariosService implements IComentariosService {

    @Autowired
    private IComentariosRepository comentarioRepository;

    @Override
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    @Override
    public Optional<Comentario> getComentarioById(String id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public Comentario createComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public Comentario updateComentario(String id, Comentario comentarioDetails) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentario no encontrado"));

        comentario.setTexto(comentarioDetails.getTexto());
        comentario.setFechaEnvio(comentarioDetails.getFechaEnvio());
        comentario.setReply(comentarioDetails.getReply());

        return comentarioRepository.save(comentario);
    }

    @Override
    public void deleteComentario(String id) {
        comentarioRepository.deleteById(id);
    }
}
