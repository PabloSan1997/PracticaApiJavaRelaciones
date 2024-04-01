package com.pablo.practica.relations.service.interfaces;

import com.pablo.practica.relations.models.Tarea;

public interface ITareaService {
    Tarea agregarTarea(Tarea nuevaTarea, Long id_user);
}
