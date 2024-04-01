package com.pablo.practica.relations.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pablo.practica.relations.models.Persona;
import com.pablo.practica.relations.models.dtos.PersonaCreadaDto;
import com.pablo.practica.relations.service.interfaces.IPersonaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/api")
public class PersonaController {

   @Autowired
   IPersonaService personaService;

   @RequestMapping(path = "/persona", method = RequestMethod.GET)
   public ResponseEntity<List<Persona>> getPersonas() {
      var respuesta = personaService.findPersonas();
      return ResponseEntity.status(HttpStatus.OK).body(respuesta);
   }

   @RequestMapping(path = "/persona/{id}", method = RequestMethod.GET)
   public ResponseEntity<?> getPersonasById(@PathVariable Long id) {
      var respuesta = personaService.findPersonaById(id);
      return ResponseEntity.status(HttpStatus.OK).body(respuesta);
   }

   @RequestMapping(path = "/persona/sintareas", method = RequestMethod.GET)
   public ResponseEntity<?> getPersonasSinTarea() {
      var respuesta = personaService.findAllPersonaCreadaDtos();
      return ResponseEntity.status(HttpStatus.OK).body(respuesta);
   }

   @RequestMapping(path = "/persona", method = RequestMethod.POST)
   public ResponseEntity<PersonaCreadaDto> crearPersona(@RequestBody Persona personanueva){
      var respuesta = personaService.createPersona(personanueva);
      return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
   }

   @RequestMapping(path = "/persona/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<?> crearPersona(@PathVariable Long id){
      personaService.eliminarPersona(id);
      return ResponseEntity.noContent().build();
   }
}
