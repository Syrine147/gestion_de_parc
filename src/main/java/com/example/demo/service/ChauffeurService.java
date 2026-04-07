package com.example.demo.service;

import com.example.demo.MODEL.Chauffeur;
import com.example.demo.repository.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChauffeurService {

    @Autowired
    private ChauffeurRepository chauffeurRepository;

    
    public Chauffeur createChauffeur(Chauffeur chauffeur) {
        chauffeur.setIdUser(null); 

        if (chauffeur.getPermis() == null || chauffeur.getPermis().isBlank())
            throw new IllegalArgumentException("Le numéro de permis est obligatoire");

        if (chauffeurRepository.existsByPermis(chauffeur.getPermis()))
            throw new RuntimeException("Ce numéro de permis existe déjà");

        return chauffeurRepository.save(chauffeur);
    }

    
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurRepository.findAll();
    }

    public Chauffeur getChauffeurById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        return chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable avec l'ID : " + id));
    }

    
    public Chauffeur updateChauffeur(Long id, Chauffeur newChauffeur) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        Chauffeur c = chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable avec l'ID : " + id));

        if (newChauffeur.getPermis() == null || newChauffeur.getPermis().isBlank())
            throw new IllegalArgumentException("Le numéro de permis est obligatoire");

        c.setPermis(newChauffeur.getPermis());
        c.setEtat(newChauffeur.getEtat());

        return chauffeurRepository.save(c);
    }

    
    public void deleteChauffeur(Long id) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        if (!chauffeurRepository.existsById(id))
            throw new RuntimeException("Chauffeur introuvable avec l'ID : " + id);

        chauffeurRepository.deleteById(id);
    }
}