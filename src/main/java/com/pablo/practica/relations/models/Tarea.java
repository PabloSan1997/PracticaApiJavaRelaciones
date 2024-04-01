package com.pablo.practica.relations.models;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tareas")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String tarea;

    @Getter @Setter
    private Boolean estado;

    @Getter @Setter
    private Date creatAt;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    @Getter @Setter
    @JsonIgnore
    private Persona persona;

    @PrePersist
    public void actualizar(){
        creatAt = new Date();
    }
}
