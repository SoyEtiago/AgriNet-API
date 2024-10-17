package com.backend.AgriNet.Service;

import com.backend.AgriNet.Model.PublicacionesModel;
import org.bson.types.ObjectId;

import java.util.List;

public interface IPublicacionesService {
    public String guardarProyecto(ProyectosModel proyecto);
    public List<ProyectosModel> listarPrpyectos();
    public ProyectosModel buscarProyectosPorId(ObjectId id);
    public String eliminarProyectos(ObjectId id);
}


