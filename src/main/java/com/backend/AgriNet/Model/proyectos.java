package com.backend.AgriNet.Model;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class proyectos {

@Document(collection = "Proyectos")
public class Proyecto {
    @Id
    private String id;
    private String creadorId;
    private String tipoCultivo;
    private String estado;
    private List<String> fotos;
    private List<Colaborador> colaboradores;
 
    // Métodos getter y setter

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    public List<Colaborador> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Colaborador> colaboradores) {
        this.colaboradores = colaboradores;
    }
}


    
}

class Colaborador {
    private String colaboradorId;
    private String nombre;
    private String estado;

    
}

    

