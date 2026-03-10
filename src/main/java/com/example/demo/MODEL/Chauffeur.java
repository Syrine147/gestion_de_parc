package com.example.demo.MODEL;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "chauffeurs")

public class Chauffeur extends Personne {

    @Column(nullable = false, unique = true)
    private String permis;

    @Column(nullable = false)
    private String etat;

    @Column(nullable = false)
    private int kilometrage;

    @OneToMany(mappedBy = "chauffeur")
    private List<Vehicule> vehicules;

}