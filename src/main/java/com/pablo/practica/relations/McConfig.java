package com.pablo.practica.relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class McConfig implements WebMvcConfigurer{
    
    @Autowired
    @Qualifier("headerinterceptor")
    private HandlerInterceptor headerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // TODO Auto-generated method stub
        registry.addInterceptor(headerInterceptor).addPathPatterns("/api/persona");
    }

    
}
