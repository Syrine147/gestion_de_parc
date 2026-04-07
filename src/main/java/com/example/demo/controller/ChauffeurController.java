package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.MODEL.Chauffeur;
import com.example.demo.service.ChauffeurService;

@RestController
@RequestMapping("/chauffeurs")
@CrossOrigin
public class ChauffeurController {

    @Autowired
    private ChauffeurService chauffeurService;

    @GetMapping
    public List<Chauffeur> getAll() {
        return chauffeurService.getAllChauffeurs();
    }

    
    @GetMapping("/{id}")
    public Chauffeur getById(@PathVariable Long id) {
        return chauffeurService.getChauffeurById(id);
    }

    
    @PostMapping
    public Chauffeur create(@RequestBody Chauffeur chauffeur) {
        return chauffeurService.createChauffeur(chauffeur);
    }

    
    @PutMapping("/{id}")
    public Chauffeur update(@PathVariable Long id, @RequestBody Chauffeur updated) {
        return chauffeurService.updateChauffeur(id, updated);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        chauffeurService.deleteChauffeur(id);
    }
}
