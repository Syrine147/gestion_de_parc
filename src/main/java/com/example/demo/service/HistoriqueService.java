package com.example.demo.service;

import com.example.demo.MODEL.Historique;
import com.example.demo.repository.HistoriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository;

    
    public Historique createHistorique(Historique historique) {

        if (historique == null)
            throw new IllegalArgumentException("Historique est obligatoire");

        if (historique.getId() != null)
            throw new IllegalArgumentException("Un nouvel historique ne doit pas avoir un ID");

        if (historique.getDescription() == null || historique.getDescription().isBlank())
            throw new IllegalArgumentException("La description est obligatoire");

        return historiqueRepository.save(historique);
    }

    public List<Historique> getAllHistoriques() {
        return historiqueRepository.findAll();
    }

    
    public Historique getHistoriqueById(Long id) {

        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        return historiqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historique introuvable avec l'ID : " + id));
    }

    
    public Historique updateHistorique(Long id, Historique newHistorique) {

        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        Historique h = historiqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historique introuvable avec l'ID : " + id));

        if (newHistorique.getDescription() == null || newHistorique.getDescription().isBlank())
            throw new IllegalArgumentException("La description est obligatoire");

        h.setDescription(newHistorique.getDescription());

        return historiqueRepository.save(h);
    }

    
    public void deleteHistorique(Long id) {

        if (id == null)
            throw new IllegalArgumentException("L'ID est obligatoire");

        if (!historiqueRepository.existsById(id))
            throw new RuntimeException("Historique introuvable avec l'ID : " + id);

        historiqueRepository.deleteById(id);
    }
}