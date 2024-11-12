package com.backend.AgriNet.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.AgriNet.Model.Proyecto;

public interface IProyectosRepository extends MongoRepository<Proyecto, String> {
}
