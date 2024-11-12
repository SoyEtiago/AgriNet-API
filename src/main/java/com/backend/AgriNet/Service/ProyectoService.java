package com.backend.AgriNet.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.AgriNet.Model.Proyecto;
import com.backend.AgriNet.Repository.IProyectosRepository;

@Service
public class ProyectoService implements IProyectosService {

    @Autowired
    private IProyectosRepository proyectoRepository;

    @Override
    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Optional<Proyecto> getProyectoById(String id) {
        return proyectoRepository.findById(id);
    }

    @Override
    public Proyecto createProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto updateProyecto(String id, Proyecto proyectoDetails) {
        Proyecto proyecto = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        proyecto.setTipoCultivo(proyectoDetails.getTipoCultivo());
        proyecto.setEstado(proyectoDetails.getEstado());
        proyecto.setFotos(proyectoDetails.getFotos());
        proyecto.setColaboradores(proyectoDetails.getColaboradores());

        return proyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(String id) {
        proyectoRepository.deleteById(id);
    }
}
