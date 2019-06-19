package com.example.jpademo.controller;

import com.example.jpademo.domain.Gym;
import com.example.jpademo.domain.Worker;
import com.example.jpademo.service.GymService;
import com.example.jpademo.service.WorkerService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

public class WorkerHandler {
    private final WorkerService workerService;
    public WorkerHandler(WorkerService workerService) {
        this.workerService = workerService;
    }
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(workerService.findById(id), Gym.class);
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(workerService.findAll(), Gym.class);
    }
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Gym> Gym = request.bodyToMono(Gym.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(Gym.flatMap(workerService::save), Gym.class));
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(workerService.deleteById(id), Void.class);
    }
}
