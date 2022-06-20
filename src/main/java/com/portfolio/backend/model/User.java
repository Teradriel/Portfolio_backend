package com.portfolio.backend.model;

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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

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

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Cursos> curso;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Estudios> estudio;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Experiencias> exp;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Idiomas> idioma;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Intereses> interes;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Mensajes> mens;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Skills> skill;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
