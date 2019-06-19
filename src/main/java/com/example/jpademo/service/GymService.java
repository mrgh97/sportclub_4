package com.example.jpademo.service;

import com.example.jpademo.domain.Gym;
import com.example.jpademo.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface GymService {
        Mono<Gym> findById(String id);
        Flux<Gym> findAll();
        Mono<Gym> save(Gym gym);
        Mono<Void> deleteById(String id);
}

