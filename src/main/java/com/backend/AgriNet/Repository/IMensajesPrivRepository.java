package com.backend.AgriNet.Repository;

import com.backend.AgriNet.Model.MensajesPrivModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;

public interface IMensajesPrivRepository extends MongoRepository<MensajesPrivModel, ObjectId> {


}
