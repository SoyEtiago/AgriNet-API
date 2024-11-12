package com.backend.AgriNet.Repository;

import com.backend.AgriNet.Model.UsuariosModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Optional;


public interface IUsuariosRepository extends MongoRepository<UsuariosModel, ObjectId> {
    @Query("{ 'email' : ?0 }")
    Optional<UsuariosModel> findByEmail(String email);
}
