package com.backend.AgriNet.Service;

import java.util.List;
import java.util.Optional;

import com.backend.AgriNet.Model.Comentario;

public interface IComentariosService {
    List<Comentario> getAllComentarios();
    Optional<Comentario> getComentarioById(String id);
    Comentario createComentario(Comentario comentario);
    Comentario updateComentario(String id, Comentario comentarioDetails);
    void deleteComentario(String id);
}
