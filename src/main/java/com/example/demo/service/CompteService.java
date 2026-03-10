package com.example.demo.service;

import com.example.demo.MODEL.Compte;
import com.example.demo.repository.CompteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    // Ajouter compte
    public Compte ajouterCompte(Compte compte){
        return compteRepository.save(compte);
    }

    // Afficher tous les comptes
    public List<Compte> getAllComptes(){
        return compteRepository.findAll();
    }

    // Chercher compte par ID
    public Compte getCompteById(String id){
        Optional<Compte> compte = compteRepository.findById(id);
        return compte.orElse(null);
    }

  
    public Compte updateCompte(Compte compte){
        return compteRepository.save(compte);
    }

   
    public void deleteCompte(String id){
        compteRepository.deleteById(id);
    }
}