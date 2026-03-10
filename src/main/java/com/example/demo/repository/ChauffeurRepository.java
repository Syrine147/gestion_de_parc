package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.MODEL.Chauffeur;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, String> {

}