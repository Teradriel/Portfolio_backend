package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="mensajes")
public class Mensajes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    private String nombre;

    private String email;
    
    private String telefono;
    
    private String web;

    private String mensaje;
}