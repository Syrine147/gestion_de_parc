package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.MODEL.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
 boolean existsByEmail(String email);
}
