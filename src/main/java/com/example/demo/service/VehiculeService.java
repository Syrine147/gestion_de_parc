package com.example.demo.service;

import com.example.demo.MODEL.Vehicule;
import com.example.demo.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehiculeService {

    @Autowired
    private VehiculeRepository vehiculeRepository;

  
    public Vehicule createVehicule(Vehicule vehicule) {
        
        
        if (vehicule.getMarque() == null || vehicule.getMarque().isBlank()) {
            throw new IllegalArgumentException("La marque est obligatoire");
        }
        if (vehicule.getModele() == null || vehicule.getModele().isBlank()) {
            throw new IllegalArgumentException("Le modèle est obligatoire");
        }

        if (vehicule.getEtat() == null || vehicule.getEtat().isBlank()) {
            vehicule.setEtat("Disponible");
        }

        return vehiculeRepository.save(vehicule);
    }

    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }

    
    public Vehicule getVehiculeById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("L'ID est obligatoire");
        }
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Véhicule introuvable avec l'ID : " + id));
    }

    public Vehicule updateVehicule(Long id, Vehicule newVehicule) {
      
        Vehicule v = getVehiculeById(id);

        
        v.setModele(newVehicule.getModele());
        v.setMarque(newVehicule.getMarque());
        v.setType(newVehicule.getType());
        v.setEtat(newVehicule.getEtat());
        
      

        return vehiculeRepository.save(v);
    }

    public void deleteVehicule(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("L'ID est obligatoire");
        }
        if (!vehiculeRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : Véhicule introuvable");
        }
        vehiculeRepository.deleteById(id);
    }
}