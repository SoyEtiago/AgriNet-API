package com.backend.AgriNet.Service;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.ProyectosModel;
import com.backend.AgriNet.Repository.IProyectosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

    @Service
    public class ProyectosServiceImp implements IProyectosService {
        @Autowired
        IProyectosRepository ProyectosRepository;
    
        @Override
        public String guardarProyecto(ProyectosModel proyecto) {
            proyectoRepository.save(proyecto);
            return String.format("el proyecto con id %s ha sido publicado exitosamente!", proyecto.getIdAsString());
        }
    
        @Override
        public List<proyectosModel> listarproyectos() {
            return List.of();
        }
    
        @Override
        public proyectosModel buscarproyectoPorId(ObjectId id) {
            Optional<proyectosModel> proyectoRecuperado = proyectoRepository.findById(id);
            return proyectoRecuperado.orElseThrow(() -> new RecursoNoEncontradoException("No existe el proyecto con id " + id));
        }
    
        @Override
        public String eliminarproyecto(ObjectId id) {
            return ""
        }
    }
