package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.MODEL.Historique;
import com.example.demo.service.HistoriqueService;

@RestController
@RequestMapping("/historiques")
@CrossOrigin
public class Historiquecontroller {

    @Autowired
    private HistoriqueService historiqueService;

    
    @GetMapping
    public List<Historique> getAll() {
        return historiqueService.getAllHistoriques();
    }

    
    @GetMapping("/{id}")
    public Historique getById(@PathVariable Long id) {
        return historiqueService.getHistoriqueById(id);
    }

    
    @PostMapping
    public Historique create(@RequestBody Historique historique) {
        return historiqueService.createHistorique(historique);
    }

   
    @PutMapping("/{id}")
    public Historique update(@PathVariable Long id, @RequestBody Historique updated) {
        return historiqueService.updateHistorique(id, updated);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        historiqueService.deleteHistorique(id);
    }
}
