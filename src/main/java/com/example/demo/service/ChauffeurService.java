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


    public Chauffeur createChauffeur(Chauffeur chauffeur){
        return chauffeurRepository.save(chauffeur);
    }

    public List<Chauffeur> getAllChauffeurs(){
        return chauffeurRepository.findAll();
    }

    
    public Chauffeur getChauffeurById(String id){
        Optional<Chauffeur> chauffeur = chauffeurRepository.findById(id);
        return chauffeur.orElse(null);
    }

    
    public Chauffeur updateChauffeur(String id, Chauffeur newChauffeur){

    Chauffeur c = chauffeurRepository.findById(id).orElse(null);

    if(c != null){

        c.setPermis(newChauffeur.getPermis());
        c.setEtat(newChauffeur.getEtat());
       

        return chauffeurRepository.save(c);
    }

    return null;
}

    
    public void deleteChauffeur(String id){
        chauffeurRepository.deleteById(id);
    }

}
