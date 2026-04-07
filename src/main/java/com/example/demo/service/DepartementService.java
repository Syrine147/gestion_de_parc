package com.example.demo.service;

import com.example.demo.MODEL.Departement;
import com.example.demo.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    
    public Departement createDepartement(Departement departement) {
        departement.setIdDep(null); 

        if (departement.getNomDep() == null || departement.getNomDep().isBlank())
            throw new IllegalArgumentException("Le nom du département est obligatoire");

        return departementRepository.save(departement);
    }

    
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    
    public Departement getDepartementById(Long id) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        return departementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Département introuvable avec l'ID : " + id));
    }

    
    public Departement updateDepartement(Long id, Departement newDep) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        Departement d = departementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Département introuvable avec l'ID : " + id));

        if (newDep.getNomDep() == null || newDep.getNomDep().isBlank())
            throw new IllegalArgumentException("Le nom du département est obligatoire");

        d.setNomDep(newDep.getNomDep());

        return departementRepository.save(d);
    }

    
    public void deleteDepartement(Long id) {
        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        if (!departementRepository.existsById(id))
            throw new RuntimeException("Département introuvable avec l'ID : " + id);

        departementRepository.deleteById(id);
    }
}