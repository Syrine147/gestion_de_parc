package com.example.demo.service;

import com.example.demo.MODEL.Chauffeur;
import com.example.demo.repository.ChauffeurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChauffeurService {

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    // Ajouter chauffeur
    public Chauffeur ajouterChauffeur(Chauffeur chauffeur){
        return chauffeurRepository.save(chauffeur);
    }

    // Afficher tous les chauffeurs
    public List<Chauffeur> getAllChauffeurs(){
        return chauffeurRepository.findAll();
    }

    // Chercher chauffeur par ID
    public Chauffeur getChauffeurById(String id){
        Optional<Chauffeur> chauffeur = chauffeurRepository.findById(id);
        return chauffeur.orElse(null);
    }

    // Modifier chauffeur
    public Chauffeur updateChauffeur(Chauffeur chauffeur){
        return chauffeurRepository.save(chauffeur);
    }

    // Supprimer chauffeur
    public void deleteChauffeur(String id){
        chauffeurRepository.deleteById(id);
    }

}
