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
public class PublicacionesServiceImp implements IPublicacionesService {
    @Autowired
    IPublicacionesRepository PublicacionesRepository;

    @Override
    public String guardarPublicacion(PublicacionesModel publicacion) {
        publicacionRepository.save(publicacion);
        return String.format("la publicacion con id %s ha sido publicada exitosamente!", publicacion.getIdAsString());
    }

    @Override
    public List<PublicacionesModel> listarPublicaciones() {
        return List.of();
    }

    @Override
    public PublicacionesModel buscarPublicacionPorId(ObjectId id) {
        Optional<PublicacionesModel> publicacionRecuperada = publicacionRepository.findById(id);
        return publicacionRecuperada.orElseThrow(() -> new RecursoNoEncontradoException("No existe la publicacion con id " + id));
    }

    @Override
    public String eliminarpublicacion(ObjectId id) {
        return ""
    }
}