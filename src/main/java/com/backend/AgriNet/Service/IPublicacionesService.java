package com.backend.AgriNet.Service;

import com.backend.AgriNet.Model.PublicacionesModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IPublicacionesService {
    public String guardarPublicacion(PublicacionesModel publicacion);
    public List<PublicacionesModel> listarPublicaciones();
    public PublicacionesModel buscarPublicacionesPorId(ObjectId id);
    public String eliminarPublicaciones(ObjectId id);
}