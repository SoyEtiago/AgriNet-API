package com.backend.AgriNet.Model;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Colaboracion {
  ObjectId proyectoId;
  Estado estado;
}
