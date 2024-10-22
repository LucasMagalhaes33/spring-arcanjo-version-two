package com.example.springarcanjo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir CORS para todos os endpoints
                .allowedOrigins("http://localhost:4200") // Permitir apenas localhost:4200
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permitir métodos HTTP específicos
                .allowedHeaders("*") // Permitir todos os headers
                .allowCredentials(true); // Permitir cookies
    }
}
