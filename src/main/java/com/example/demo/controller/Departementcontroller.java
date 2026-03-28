package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.MODEL.Departement;
import com.example.demo.service.DepartementService;

@RestController
@RequestMapping("/departements")
@CrossOrigin
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    
    @GetMapping
    public List<Departement> getAll() {
        return departementService.getAllDepartements();
    }

   
    @GetMapping("/{id}")
    public Departement getById(@PathVariable String id) {
        return departementService.getDepartementById(id);
    }

  
    @PostMapping
    public Departement create(@RequestBody Departement departement) {
        return departementService.createDepartement(departement);
    }

    
    @PutMapping("/{id}")
    public Departement update(@PathVariable String id, @RequestBody Departement updated) {
        return departementService.updateDepartement(id, updated);
    }

   
}
