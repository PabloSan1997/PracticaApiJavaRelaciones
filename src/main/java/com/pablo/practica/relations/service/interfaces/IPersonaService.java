package com.pablo.practica.relations.service.interfaces;

import java.util.List;

import com.pablo.practica.relations.models.Persona;
import com.pablo.practica.relations.models.dtos.PersonaCreadaDto;

public interface IPersonaService {
    List<Persona> findPersonas();
    Persona findPersonaById(Long id);
    PersonaCreadaDto createPersona(Persona nuevaPersona);
    List<PersonaCreadaDto> findAllPersonaCreadaDtos();
    void eliminarPersona(Long id);
}
