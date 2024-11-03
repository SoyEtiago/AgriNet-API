package com.backend.AgriNet.Repository;

import com.backend.AgriNet.Model.UsuariosModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUsuariosRepository extends MongoRepository<UsuariosModel, ObjectId> {



}