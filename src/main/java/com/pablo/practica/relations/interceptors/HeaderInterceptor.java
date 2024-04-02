package com.pablo.practica.relations.interceptors;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablo.practica.relations.models.dtos.ErrorDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("headerinterceptor")
public class HeaderInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(HeaderInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        var hola = request.getHeader("ver");
       
        if(hola!=null && hola.compareTo("mira")==0){
            return true;
        }
        ObjectMapper mapper = new ObjectMapper();
        ErrorDto error = new ErrorDto();
        error.setDate(new Date());
        error.setStatus(400);
        error.setMessage("No tienes permiso para usar esta api");
        error.setError("Bad Request");
        response.setContentType("application/json");
        response.setStatus(400);
        response.getWriter().write(mapper.writeValueAsString(error));
        return false;
    }

}
