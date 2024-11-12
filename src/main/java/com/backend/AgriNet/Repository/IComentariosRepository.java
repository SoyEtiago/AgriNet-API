package com.backend.AgriNet.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.AgriNet.Model.Comentario;

public interface IComentariosRepository extends MongoRepository<Comentario, String> {
}
