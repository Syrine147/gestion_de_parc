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

    
    public Departement ajouterDepartement(Departement departement){
        return departementRepository.save(departement);
    }

    
    public List<Departement> getAllDepartements(){
        return departementRepository.findAll();
    }

    
    public Departement getDepartementById(String id){
        Optional<Departement> departement = departementRepository.findById(id);
        return departement.orElse(null);
    }

    
    public Departement updateDepartement(String id, Departement newDep){

    Departement d = departementRepository.findById(id).orElse(null);

    if(d != null){
        d.setNomDep(newDep.getNomDep());
        return departementRepository.save(d);
    }

    return null;
}

    
    

}
