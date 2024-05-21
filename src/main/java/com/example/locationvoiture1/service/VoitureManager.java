package com.example.locationvoiture1.service;

import com.example.locationvoiture1.dao.entities.Voiture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface VoitureManager {

    public Voiture saveVoiture(Voiture voiture);
    public Voiture addVoiture(Voiture voiture);
    public Voiture updateVoiture(Voiture voiture);
    public boolean deleteVoiture(Voiture voiture);
    public boolean deleteVoitureById(Integer id);
    public List<Voiture> getAllVoitures();
    public Voiture getVoitureById(Long id);
    Page<Voiture> getAllVoitureByPage(int page, int size);
    public  Page<Voiture> getAllVoitures(int page, int taille, String keyword);
}

