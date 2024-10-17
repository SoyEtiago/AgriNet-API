package com.backend.AgriNet.Service;

import com.backend.AgriNet.Exception.RecursoNoEncontradoException;
import com.backend.AgriNet.Model.PublicacionesModel;
import com.backend.AgriNet.Repository.IPublicacionesRepository;
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
    public String guardarPublicacion(ComentariosModel package com.backend.AgriNet.Service;

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
        public String guardarComentario(ComentariosModel comentario) {
            comentarioRepository.save(comentario);
            return String.format("El publicacion con id %s ha sido publicado exitosamente!", publicacion.getIdAsString());
        }
    
        @Override
        public List<ComentariosModel> listarComentarios() {
            return List.of();
        }
    
        @Override
        public ComentariosModel buscarComentarioPorId(ObjectId id) {
            Optional<ComentariosModel> comentarioRecuperado = comentarioRepository.findById(id);
            return comentarioRecuperado.orElseThrow(() -> new RecursoNoEncontradoException("No existe el comentario con id " + id));
        }
    
        @Override
        public String eliminarComentario(ObjectId id) {
            return ""
        }
    }) {
        comentarioRepository.save(publicacion);
        return String.format("la publicacion con id %s ha sido publicadada exitosamente!", publicacion.getIdAsString());
    }

    @Override
    public List<ComentariosModel> listarComentarios() {
        return List.of();
    }

    @Override
    public ComentariosModel buscarComentarioPorId(ObjectId id) {
        Optional<ComentariosModel> comentarioRecuperado = comentarioRepository.findById(id);
        return comentarioRecuperado.orElseThrow(() -> new RecursoNoEncontradoException("No existe el comentario con id " + id));
    }

    @Override
    public String eliminarComentario(ObjectId id) {
        return ""
    }
}