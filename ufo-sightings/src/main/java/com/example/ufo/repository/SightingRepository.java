package com.example.ufo.repository;

import com.example.ufo.model.Sighting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SightingRepository extends JpaRepository<Sighting, Long> {
}
