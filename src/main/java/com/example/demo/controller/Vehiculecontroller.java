package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.MODEL.Vehicule;
import com.example.demo.service.VehiculeService;

@RestController
@RequestMapping("/vehicules")
@CrossOrigin
public class Vehiculecontroller {

    @Autowired
    private VehiculeService vehiculeService;

   
    @GetMapping
    public List<Vehicule> getAll() {
        return vehiculeService.getAllVehicules();
    }

    
    @GetMapping("/{matricule}")
    public Vehicule getById(@PathVariable long matricule) {
        return vehiculeService.getVehiculeById(matricule);
    }

   
    @PostMapping
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.createVehicule(vehicule);
    }

    
    @PutMapping("/{id}")
    public Vehicule update(@PathVariable long id, @RequestBody Vehicule updated) {
        return vehiculeService.updateVehicule(id, updated);
    }

    
    @DeleteMapping("/{matricule}")
    public void delete(@PathVariable Long matricule) {
        vehiculeService.deleteVehicule(matricule);
    }
}
