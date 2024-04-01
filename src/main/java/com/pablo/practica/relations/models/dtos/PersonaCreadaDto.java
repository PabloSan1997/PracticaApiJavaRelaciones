package com.pablo.practica.relations.models.dtos;

import lombok.Getter;
import lombok.Setter;

public class PersonaCreadaDto {
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer edad;

    public PersonaCreadaDto() {
    }

    public PersonaCreadaDto(Long id, String name, Integer edad) {
        this.id = id;
        this.name = name;
        this.edad = edad;
    }

}
