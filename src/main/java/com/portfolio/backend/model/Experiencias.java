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
public class Experiencias {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String descripcion;
    private String empresa;
    private String year_incio;
    private String year_fin;
    private String competencias;

    public Experiencias() {
    }

    public Experiencias(Long id, String descripcion, String empresa, String year_incio, String year_fin, String competencias) {
        this.id = id;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.year_incio = year_incio;
        this.year_fin = year_fin;
        this.competencias = competencias;
    }

    
    
    
    
}
