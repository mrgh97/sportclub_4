package com.example.jpademo.service;

import com.example.jpademo.domain.Gym;
import com.example.jpademo.repository.GymRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GymServiceImpl implements GymService {
    private GymRepository gymRepository;
    public GymServiceImpl(GymRepository gymRepository) {
        this.gymRepository = gymRepository;
    }
    @Override
    public Mono<Gym> findById(String id) {
        return gymRepository.findById(id);
    }
    @Override
    public Flux<Gym> findAll() {
        return gymRepository.findAll();
    }
    @Override
    public Mono<Gym> save(Gym gym) {
        return gymRepository.save(gym);
    }
    @Override
    public Mono<Void> deleteById(String id) {
        return gymRepository.deleteById(id);
    }
}