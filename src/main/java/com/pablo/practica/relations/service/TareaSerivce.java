package com.pablo.practica.relations.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pablo.practica.relations.exceptions.NotFoundData;
import com.pablo.practica.relations.models.Persona;
import com.pablo.practica.relations.models.Tarea;
import com.pablo.practica.relations.repository.PersonaRepository;
import com.pablo.practica.relations.repository.TareaRepositorio;
import com.pablo.practica.relations.service.interfaces.ITareaService;

@Service
public class TareaSerivce implements ITareaService {

    @Autowired
    private TareaRepositorio tareaRepositorio;

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    @Transactional
    public Tarea agregarTarea(Tarea nuevaTarea, Long id_user) {
        Optional<Persona> opPersona = personaRepository.findById(id_user);
        
        if (opPersona.isPresent() && nuevaTarea != null) {
            Persona persona = opPersona.orElseThrow();
            nuevaTarea.setPersona(persona);
            var res = tareaRepositorio.save(nuevaTarea);
            return res;
        }
        throw new NotFoundData("No se encontro usuario");
    }

}
