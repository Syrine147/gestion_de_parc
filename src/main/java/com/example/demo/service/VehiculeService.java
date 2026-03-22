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

    
    public Vehicule ajouterVehicule(Vehicule vehicule){
        return vehiculeRepository.save(vehicule);
    }

   
    public List<Vehicule> getAllVehicules(){
        return vehiculeRepository.findAll();
    }

   
    public Vehicule getVehiculeById(String matricule){
        Optional<Vehicule> vehicule = vehiculeRepository.findById(matricule);
        return vehicule.orElse(null);
    }

   
    public Vehicule updateEntity(String id, Vehicule newVehicule){

    Vehicule v = vehiculeRepository.findById(id).orElse(null);

    if(vehiculeRepository != null){

        
        v.setIdVeh(newVehicule.getIdVeh());
        v.setMarque(newVehicule.getMarque());
        v.setModele(newVehicule.getModele());
        v.setType(newVehicule.getType());
        v.setEtat(newVehicule.getEtat());

        return vehiculeRepository.save(v);
    }

    return null;
}

    
    public void deleteVehicule(String matricule){
        vehiculeRepository.deleteById(matricule);
    }
}