package com.backend.AgriNet.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seguido {
    @Id
    private ObjectId seguidoId;
    private String nombreSeguido;
}
