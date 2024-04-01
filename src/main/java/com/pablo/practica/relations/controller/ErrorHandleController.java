package com.pablo.practica.relations.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.pablo.practica.relations.exceptions.NotFoundData;
import com.pablo.practica.relations.models.dtos.ErrorDto;

@RestControllerAdvice
public class ErrorHandleController {
    
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<?> notData(Exception ex){
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setError("Error con datos");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
    @ExceptionHandler({NotFoundData.class})
    public ResponseEntity<?> notfound(Exception ex){
       ErrorDto error = new ErrorDto();
       error.setDate(new Date());
       error.setStatus(HttpStatus.NOT_FOUND.value());
       error.setMessage(ex.getMessage());
       error.setError("No existe datos");
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler({NoResourceFoundException.class})
    public ResponseEntity<?> notfoundGeneral(Exception ex){
       ErrorDto error = new ErrorDto();
       error.setDate(new Date());
       error.setStatus(HttpStatus.NOT_FOUND.value());
       error.setMessage(ex.getMessage());
       error.setError("No existe datos");
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
