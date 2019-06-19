package com.example.jpademo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

public class GymRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GymHandler handler) {
        return RouterFunctions
                .route(GET("/api/gym").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/api/gym/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
                .andRoute(POST("/api/gym").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/api/gym/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }

}
