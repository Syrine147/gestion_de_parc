package com.example.demo.service;

import com.example.demo.MODEL.Departement;
import com.example.demo.repository.DepartementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    // Ajouter departement
    public Departement ajouterDepartement(Departement departement){
        return departementRepository.save(departement);
    }

    // Afficher tous les departements
    public List<Departement> getAllDepartements(){
        return departementRepository.findAll();
    }

    // Chercher departement par ID
    public Departement getDepartementById(String id){
        Optional<Departement> departement = departementRepository.findById(id);
        return departement.orElse(null);
    }

    // Modifier departement
    public Departement updateDepartement(Departement departement){
        return departementRepository.save(departement);
    }

    // Supprimer departement
    public void deleteDepartement(String id){
        departementRepository.deleteById(id);
    }

}
