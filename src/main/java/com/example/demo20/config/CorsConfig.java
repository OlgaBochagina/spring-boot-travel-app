package com.example.demo20.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Конфигурация CORS.
     * Метод addCorsMappings настраивает разрешенные источники для CORS запросов.
     * Это позволяет указывать, какие домены, методы и заголовки разрешены для обращения к серверу.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Разрешаем CORS для всех путей
                .allowedOrigins("http://localhost:63342") // Разрешаем определенные фронтенды
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Разрешаем только определенные HTTP методы
                .allowedHeaders("*") // Разрешаем все заголовки
                .allowCredentials(true) // Разрешаем отправку cookies и авторизационных заголовков
                .maxAge(3600); // Время в секундах, на которое разрешается кэшировать CORS запросы
    }

}

