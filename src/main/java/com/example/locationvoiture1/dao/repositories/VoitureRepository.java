package com.example.locationvoiture1.dao.repositories;

import com.example.locationvoiture1.dao.entities.Voiture;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Transactional
public interface VoitureRepository extends JpaRepository<Voiture,Long> {
    Page<Voiture> findByMatriculeContains(String keyword, Pageable pageable);
}
