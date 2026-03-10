package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.MODEL.Employer;

public interface EmployerRepository extends JpaRepository<Employer, String> {

}
