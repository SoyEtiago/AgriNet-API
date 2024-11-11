package com.backend.AgriNet.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "MensajesPriv")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MensajesPrivModel {

    @Id
    @JsonIgnore
    private ObjectId _id;
    private Usuarios usuarios;
    private List<Mensaje> mensajes = new ArrayList<>();
    private Replica replica;

    @JsonProperty("_id")
    public String getIdAsString() {
        return _id != null ? _id.toHexString() : null;
    }
    
    public static class Replica {
        private ObjectId remitente;
        private TipoRecurso tipoRecurso;
        private String texto;
        private Date fechaEnvio;

        public static class TipoRecurso {
            private String tipoDato;
            private List<String> recurso = new ArrayList<>();
        }
    }
}
