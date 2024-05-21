package com.example.locationvoiture1.service;

import com.example.locationvoiture1.dao.entities.Voiture;
import com.example.locationvoiture1.dao.repositories.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;

import java.util.List;
@Service
public class VoitureManagerService implements VoitureManager{
    @Autowired
    VoitureRepository voitureRepository;
    @Override
    public Voiture saveVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }
    @Override
    public Voiture addVoiture(Voiture voiture){
        try{
            return voitureRepository.save(voiture);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
    @Override
    public Voiture updateVoiture(Voiture voiture){
        return null;
    }
    @Override
    public boolean deleteVoiture(Voiture voiture){
        return false;
    }
    @Override
    public boolean deleteVoitureById(Integer id){
        return false;
    }
    @Override
    public List<Voiture> getAllVoitures(){
        return voitureRepository.findAll();
    }
    @Override
    public  Page<Voiture> getAllVoitures(int page, int taille, String keyword) {
        return voitureRepository.findByMatriculeContains(keyword, PageRequest.of( page, taille ));
    }
    @Override
    public Voiture getVoitureById(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }
    @Override
    public Page<Voiture> getAllVoitureByPage(int page, int size) {
        return voitureRepository.findAll(PageRequest.of(page, size));
    }
}

