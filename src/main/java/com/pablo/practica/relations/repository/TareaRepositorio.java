package com.pablo.practica.relations.repository;

import org.springframework.data.repository.CrudRepository;

import com.pablo.practica.relations.models.Tarea;

public interface TareaRepositorio extends CrudRepository<Tarea, Long> {
    
}
