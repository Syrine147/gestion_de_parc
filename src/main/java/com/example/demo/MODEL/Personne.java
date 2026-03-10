package com.example.demo.MODEL;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "personnes")

public class Personne {

    @Id
    @Column(name = "id_user")
    private String idUser;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String email;

    private String tel;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String role;

}