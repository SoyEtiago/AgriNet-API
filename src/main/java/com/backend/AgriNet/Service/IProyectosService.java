package com.backend.AgriNet.Service;

import java.util.List;
import java.util.Optional;

import com.backend.AgriNet.Model.Proyecto;

public interface IProyectosService {
    List<Proyecto> getAllProyectos();
    Optional<Proyecto> getProyectoById(String id);
    Proyecto createProyecto(Proyecto proyecto);
    Proyecto updateProyecto(String id, Proyecto proyectoDetails);
    void deleteProyecto(String id);
}
