package com.example.demo.service;

import com.example.demo.MODEL.Historique;
import com.example.demo.repository.HistoriqueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriqueService {

    @Autowired
    private HistoriqueRepository historiqueRepository;

   
    public Historique ajouterHistorique(Historique historique){
        return historiqueRepository.save(historique);
    }

    
    public List<Historique> getAllHistoriques(){
        return historiqueRepository.findAll();
    }

   
    public Historique getHistoriqueById(Long id){
        Optional<Historique> historique = historiqueRepository.findById(id);
        return historique.orElse(null);
    }

   
    public Historique updateHistorique(Historique historique){
        return historiqueRepository.save(historique);
    }

    
    public void deleteHistorique(Long id){
        historiqueRepository.deleteById(id);
    }

}
