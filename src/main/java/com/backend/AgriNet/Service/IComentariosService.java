package com.backend.AgriNet.Service;

import com.backend.AgriNet.Model.ComentariosModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IComentariosService {
    public String guardarComentario(ComentariosModel usuario);
    public List<ComentariosModel> listarComentarios();
    public ComentariosModel buscarComentariosPorId(ObjectId id);
    public String eliminarComentarios(ObjectId id);
}


