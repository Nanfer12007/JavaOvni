package com.example.ufo.service;

import com.example.ufo.model.Sighting;
import com.example.ufo.repository.SightingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SightingService {

    private final SightingRepository repository;

    public SightingService(SightingRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Sighting> listAll() {
        return repository.findAll();
    }

    @Transactional
    public Sighting save(Sighting s) {
        return repository.save(s);
    }
}
