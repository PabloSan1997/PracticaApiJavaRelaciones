package com.pablo.practica.relations.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "personas" )
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String name;
    @Getter @Setter
    private Integer edad;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "persona")
    @Getter @Setter
    List<Tarea> tareas;

    
}
