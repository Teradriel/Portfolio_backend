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
public class Mensajes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    private String nombre;
    private String email;
    private String telefono;
    private String web;
    private String mensaje;

    public Mensajes() {
    }

    public Mensajes(Long id, String nombre, String email, String telefono, String web, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.web = web;
        this.mensaje = mensaje;
    }
    
    
    
}
