package com.example.locationvoiture1.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
@Getter
@Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Admine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nom;
    private String prenom;
    @OneToMany(mappedBy="admin")
    private Collection<Client> clients=new ArrayList<>();

    @OneToOne
    private Agence agence;
}

