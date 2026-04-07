package com.example.demo.MODEL;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;      
import java.time.LocalDateTime;  

@Entity
@Table(name = "disponibilite")
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Disponibilite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chauffeur_id", nullable = false)
    private Chauffeur chauffeur;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private Motif motif = Motif.CONGE;

    private String note;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Motif {
        CONGE, MALADIE, MISSION, AUTRE
    }
}