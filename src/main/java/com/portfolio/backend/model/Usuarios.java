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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String usuario;
    private String pass;
    private String mail;
    private String nombre;
    private String apellido;
    private String telefono;
    private Mensajes mensaje;
    private Estudios estudios;
    private Experiencias experiencias;
    private Introduccion introduccion;
    private Skills skills;

    public Usuarios() {
    }

    public Usuarios(Long id, String usuario, String pass, String mail, String nombre, String apellido, String telefono, Mensajes mensaje, Estudios estudios, Experiencias experiencias, Introduccion introduccion, Skills skills) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.mensaje = mensaje;
        this.estudios = estudios;
        this.experiencias = experiencias;
        this.introduccion = introduccion;
        this.skills = skills;
    }

    

    
    
    
    
}
