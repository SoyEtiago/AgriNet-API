package com.backend.AgriNet;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class colaborador {
   @Id
   private ObjectId colaboradorId;
   private String nombre; 

}
