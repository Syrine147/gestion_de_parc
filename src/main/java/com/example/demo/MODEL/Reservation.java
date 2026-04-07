package com.example.demo.MODEL;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false)
    private String lieuDepart;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepart;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
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