package com.pablo.practica.relations.models.dtos;

import lombok.Getter;

public class NotFoundDto {
    @Getter
    private Integer status;
    @Getter
    private String message;
    
    public NotFoundDto(Integer status, String message) {
        this.status = status;
        this.message = message;
    }


}
