package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.VehiculeRepository;
import com.example.demo.MODEL.Vehicule;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

    // ajouter vehicule
    public Vehicule ajouterVehicule(Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }

    // afficher tous les vehicules
    public List<Vehicule> getAllVehicules(){
        return vehiculeRepository.findAll();
    }

    // chercher vehicule par matricule
    public Vehicule getVehiculeById(String matricule){
        Optional<Vehicule> vehicule = vehiculeRepository.findById(matricule);
        return vehicule.orElse(null);
    }

    // modifier vehicule
    public Vehicule updateVehicule(Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }

    // supprimer vehicule
    public void deleteVehicule(String matricule){
        vehiculeRepository.deleteById(matricule);
    }
}