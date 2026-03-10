package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.example.demo.repository.PersonneRepository;
import com.example.demo.MODEL.Personne;

@Service
public class PersonneService {

    @Autowired
    private PersonneRepository personneRepository;

    // ajouter personne
    public Personne ajouterPersonne(Personne personne){
        return personneRepository.save(personne);
    }

    // afficher toutes les personnes
    public List<Personne> getAllPersonnes(){
        return personneRepository.findAll();
    }

    // chercher personne par id
    public Personne getPersonneById(String id){
        Optional<Personne> personne = personneRepository.findById(id);
        return personne.orElse(null);
    }

    // modifier personne
    public Personne updatePersonne(Personne personne){
        return personneRepository.save(personne);
    }

    // supprimer personne
    public void deletePersonne(String id){
        personneRepository.deleteById(id);
    }
}