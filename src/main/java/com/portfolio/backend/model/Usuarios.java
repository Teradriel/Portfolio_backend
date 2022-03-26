package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String usuario;
    private String pass;

    public Usuarios() {
    }

    public Usuarios(Long id, String usuario, String pass) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
    }
    
    
    
}
