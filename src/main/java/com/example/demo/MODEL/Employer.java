package com.example.demo.MODEL;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employes")

public class Employer extends Personne {

    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;

    @OneToMany(mappedBy = "employe")
    private List<Reservation> reservations;

}