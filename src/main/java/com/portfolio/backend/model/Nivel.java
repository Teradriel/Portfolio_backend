//package com.portfolio.backend.model;
//
//import java.util.Set;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "nivel")
//public class Nivel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private int nivel;
//    
//    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Set<Skills> skill;
//}
