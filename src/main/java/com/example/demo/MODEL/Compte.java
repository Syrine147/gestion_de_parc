package com.example.demo.MODEL;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "comptes")

public class Compte {

    @Id
    @Column(nullable = false, unique = true)
    private String idC;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

}