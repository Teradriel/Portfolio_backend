package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estudios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descripcion;
    private String Institucion;

    public Estudios() {
    }

    public Estudios(Long id, String descripcion, String Institucion) {
        this.id = id;
        this.descripcion = descripcion;
        this.Institucion = Institucion;
    }

    
       
}
