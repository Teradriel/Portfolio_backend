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
    private Long id_mensaje;
    private Long id_estudios;
    private Long id_experiencias;
    private Long id_introduccion;
    private Long id_skills;

    public Usuarios() {
    }

    public Usuarios(Long id, String usuario, String pass, String mail, String nombre, String apellido, String telefono, Long id_mensaje, Long id_estudios, Long id_experiencias, Long id_introduccion, Long id_skills) {
        this.id = id;
        this.usuario = usuario;
        this.pass = pass;
        this.mail = mail;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.id_mensaje = id_mensaje;
        this.id_estudios = id_estudios;
        this.id_experiencias = id_experiencias;
        this.id_introduccion = id_introduccion;
        this.id_skills = id_skills;
    }

    

    

    
    
    
    
}
