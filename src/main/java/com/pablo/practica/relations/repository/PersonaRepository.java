package com.pablo.practica.relations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pablo.practica.relations.models.Persona;
import com.pablo.practica.relations.models.dtos.PersonaCreadaDto;

public interface PersonaRepository extends CrudRepository<Persona, Long> {

    @Query("select new com.pablo.practica.relations.models.dtos.PersonaCreadaDto(p.id, p.name, p.edad) from Persona p")
    List<PersonaCreadaDto> findPersonaSinTareas();
}
