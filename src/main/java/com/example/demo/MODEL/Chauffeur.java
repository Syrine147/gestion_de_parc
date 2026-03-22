package com.example.demo.MODEL;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


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


  

}