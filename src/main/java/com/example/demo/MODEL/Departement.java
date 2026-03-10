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
@Table(name = "departements")

public class Departement {

    @Id
    @Column(nullable = false)
    private String idDep;

    @Column(nullable = false)
    private String nomDep;

    @OneToMany(mappedBy = "departement")
    private List<Employer> employes;

}