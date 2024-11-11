package com.backend.AgriNet.Repository;

import com.backend.AgriNet.Model.UsuariosModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface IUsuariosRepository extends MongoRepository<UsuariosModel, ObjectId> {

}
