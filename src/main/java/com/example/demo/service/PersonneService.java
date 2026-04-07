package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.repository.PersonneRepository;
import com.example.demo.MODEL.Personne;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

  
    public Personne createPersonne(Personne personne) {
        personne.setIdUser(null); 

        if (personne.getNom() == null || personne.getNom().isBlank())
            throw new IllegalArgumentException("Le nom est obligatoire");

        if (personne.getEmail() == null || personne.getEmail().isBlank())
            throw new IllegalArgumentException("L'email est obligatoire");

        if (personneRepository.existsByEmail(personne.getEmail()))
            throw new RuntimeException("Cet email existe déjà");

        return personneRepository.save(personne);
    }

   
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }

  
    public Personne getPersonneById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        return personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personne introuvable avec l'ID : " + id));
    }

    
    public Personne updatePersonne(Long id, Personne newPersonne) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        Personne p = personneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Personne introuvable avec l'ID : " + id));

        p.setNom(newPersonne.getNom());
        p.setPrenom(newPersonne.getPrenom());
        p.setEmail(newPersonne.getEmail());
        p.setTel(newPersonne.getTel());
        p.setRole(newPersonne.getRole());
        p.setPassword(newPersonne.getPassword());

        return personneRepository.save(p);
    }

   
    public void deletePersonne(Long id) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        if (!personneRepository.existsById(id))
            throw new RuntimeException("Personne introuvable avec l'ID : " + id);

        personneRepository.deleteById(id);
    }
}