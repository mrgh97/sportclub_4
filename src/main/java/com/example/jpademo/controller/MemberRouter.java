package com.example.jpademo.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

public class MemberRouter {
    @Bean
    public RouterFunction<ServerResponse> route(GymHandler handler) {
        return RouterFunctions
                .route(GET("/api/member").and(accept(MediaType.APPLICATION_JSON)), handler::findAll)
                .andRoute(GET("/api/member/{id}").and(accept(MediaType.APPLICATION_STREAM_JSON)), handler::findById)
                .andRoute(POST("/api/member").and(accept(MediaType.APPLICATION_JSON)), handler::save)
                .andRoute(DELETE("/api/member/{id}").and(accept(MediaType.APPLICATION_JSON)), handler::delete);
    }
}
