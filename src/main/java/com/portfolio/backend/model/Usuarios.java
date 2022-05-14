package com.portfolio.backend.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String apellido;
    private String telefono;
    private String pais;
    private String ciudad;
    private String direccion;
    private String fechaNacimiento;
    private String sexo;
    private String estadoCivil;
    private String imagen;
    private String intro;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_data",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private Set<Cursos> curso;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_data",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "estudio_id"))
    private Set<Estudios> estudio;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_data",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "experiencia_id"))
    private Set<Experiencias> exp;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_data",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "idioma_id"))
    private Set<Idiomas> idioma;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_data",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "interes_id"))
    private Set<Intereses> interes;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_data",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "mensajes_id"))
    private Set<Mensajes> mens;
        
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "usuario_data",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skills> skill;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "user_usuario",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User user;
    
}
