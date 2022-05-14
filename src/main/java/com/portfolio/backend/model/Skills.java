package com.portfolio.backend.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String skill;
    
//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(name = "skill_nivel",
//            joinColumns = @JoinColumn(name = "skill_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "nivel_id", referencedColumnName = "id"))
//    private Set<Nivel> nivel= new HashSet<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "skill_nivel",
            joinColumns = @JoinColumn(name = "nivel_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Nivel nivel;
}
