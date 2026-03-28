package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.MODEL.Personne;
import com.example.demo.service.PersonneService;

@RestController
@RequestMapping("/personnes")
@CrossOrigin
public class PersonneController {

    @Autowired
    private PersonneService personneService;

    
    @GetMapping
    public List<Personne> getAll(){
        return personneService.getAllPersonnes();
    }

    
    @GetMapping("/{id}")
    public Personne getById(@PathVariable String id){
        return personneService.getPersonneById(id);
    }

    
    @PostMapping
    public Personne create(@RequestBody Personne newPersonne){
        return personneService.createPersonne(newPersonne);
    }

    
    @PutMapping("/{id}")
    public Personne update(@PathVariable String id, @RequestBody Personne updated){
        return personneService.updatePersonne(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        personneService.deletePersonne(id);
    }

}