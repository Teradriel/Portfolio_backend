package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Introduccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descripcion;

    public Introduccion() {
    }

    public Introduccion(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    
}
