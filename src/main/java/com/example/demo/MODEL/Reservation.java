package com.example.demo.MODEL;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reservations")

public class Reservation {

    @Id
    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String lieuDepart;

    @Column(nullable = false)
    private Date dateDepart;

    @Column(nullable = false)
    private Date dateArrive;

    @Column(nullable = false)
    private String lieuArrive;

    private String statut;

    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employer employe;

    @ManyToOne
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    @OneToOne
    @JoinColumn(name = "historique_id")
    private Historique historique;

}