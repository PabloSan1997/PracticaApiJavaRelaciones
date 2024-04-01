package com.pablo.practica.relations.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pablo.practica.relations.models.Tarea;
import com.pablo.practica.relations.service.interfaces.ITareaService;

@RestController
@RequestMapping("/api")
public class TareaController {
    
    @Autowired
    private ITareaService tareaService;

    @RequestMapping(path = "/tarea/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> crearTarea(@PathVariable Long id, @RequestBody Tarea nuevaTarea){
        var res = tareaService.agregarTarea(nuevaTarea, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
}
