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
@Table(name = "vehicules")

public class Vehicule {

    @Id
    @Column(nullable = false, unique = true)
    private String idVeh;

    @Column(nullable = false)
    private String modele;

    @Column(nullable = false)
    private String marque;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String etat;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id")
    private Chauffeur chauffeur;

    @OneToMany(mappedBy = "vehicule")
    private List<Reservation> reservations;

}