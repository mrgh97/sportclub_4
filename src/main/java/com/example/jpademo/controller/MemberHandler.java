package com.example.jpademo.controller;

import com.example.jpademo.domain.Gym;
import com.example.jpademo.service.GymService;
import com.example.jpademo.service.MemberService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.lang.reflect.Member;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

public class MemberHandler {
    private final MemberService memberService;
    public MemberHandler(GymService gymService)
    {
        this.memberService = memberService;
    }
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(memberService.findById(id), Gym.class);
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(memberService.findAll(), Gym.class);
    }
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Gym> Gym = request.bodyToMono(Gym.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(Gym.flatMap(memberService::save), Gym.class));
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(memberService.deleteById(id), Void.class);
    }
}
