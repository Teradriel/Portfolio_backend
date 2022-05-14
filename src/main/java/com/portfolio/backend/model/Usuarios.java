package com.portfolio.backend.model;

//import java.util.HashSet;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
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
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Cursos> curso = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Estudios> estudio = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Experiencias> exp = new HashSet<>();
    
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Idiomas> idioma = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Intereses> interes = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Mensajes> mens = new HashSet<>();
        
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private Set<Skills> skill = new HashSet<>();
    
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "usuario")
    private User user;
}
