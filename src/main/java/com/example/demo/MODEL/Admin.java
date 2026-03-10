package com.example.demo.MODEL;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "admins")

public class Admin extends Personne {

    @OneToMany(mappedBy = "admin")
    private List<Compte> comptes;

}