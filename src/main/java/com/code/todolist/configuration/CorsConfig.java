package com.code.todolist.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v1/**")
                .allowedOrigins("*") // Permitir todas as origens (pode ser restrito para a origem do frontend)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos permitidos
                .allowedHeaders("*"); // Cabeçalhos permitidos
    }
}
