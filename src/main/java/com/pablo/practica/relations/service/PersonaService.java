package com.pablo.practica.relations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablo.practica.relations.exceptions.NotFoundData;
import com.pablo.practica.relations.models.Persona;
import com.pablo.practica.relations.models.dtos.PersonaCreadaDto;
import com.pablo.practica.relations.repository.PersonaRepository;
import com.pablo.practica.relations.service.interfaces.IPersonaService;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findPersonas() {
        List<Persona> personas = (List<Persona>) personaRepository.findAll();
        return personas;
    }

    @Override
    @Transactional
    public Persona findPersonaById(Long id) {
        if (id == null)
            throw new NotFoundData("No existe id");
        Optional<Persona> opPersona = personaRepository.findById(id);
        if (opPersona.isPresent()) {
            Persona persona =  opPersona.orElseThrow();
            return persona;
        }
        throw new NotFoundData("No se encontro persona");
    }

    @Override
    @Transactional
    public PersonaCreadaDto createPersona(Persona nuevaPersona) {
        if (nuevaPersona.getName() == null)
            return null;
        var crear = personaRepository.save(nuevaPersona);
        PersonaCreadaDto respuesta = new PersonaCreadaDto();
        respuesta.setId(crear.getId());
        respuesta.setEdad(crear.getEdad());
        respuesta.setName(crear.getName());
        return respuesta;
    }

    @Override
    @Transactional
    public List<PersonaCreadaDto> findAllPersonaCreadaDtos() {
        return personaRepository.findPersonaSinTareas();
    }

    @Override
    @Transactional
    public void eliminarPersona(Long id) {
        if (id != null)
            personaRepository.deleteById(id);
    }

}
