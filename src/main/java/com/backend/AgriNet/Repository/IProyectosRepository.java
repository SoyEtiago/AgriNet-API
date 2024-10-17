package com.backend.AgriNet.Repository;

import com.backend.AgriNet.Model.ProyectosModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProyectosRepository extends MongoRepository<ProyectosModel, ObjectId >{
    
}
