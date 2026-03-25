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

    
    public Personne createPersonne(Personne personne){
        return personneRepository.save(personne);
    }

    
    public List<Personne> getAllPersonnes(){
        return personneRepository.findAll();
    }

    
    public Personne getPersonneById(String id){
        Optional<Personne> personne = personneRepository.findById(id);
        return personne.orElse(null);
    }

    public Personne updatePersonne(String id, Personne newPersonne){

    Personne p = personneRepository.findById(id).orElse(null);

    if(p != null){
        p.setIdUser(newPersonne.getIdUser());
        p.setNom(newPersonne.getNom());
        p.setPrenom(newPersonne.getPrenom());
        p.setEmail(newPersonne.getEmail());
        p.setTel(newPersonne.getTel());
        p.setRole(newPersonne.getRole());
        p.setPassword(newPersonne.getPassword());

        return personneRepository.save(p);
    }

    return null;
}

   
    public void deletePersonne(String id){
        personneRepository.deleteById(id);
    }
}