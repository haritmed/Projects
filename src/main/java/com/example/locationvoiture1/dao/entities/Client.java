package com.example.locationvoiture1.dao.entities;

import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String nom;
    private String prenom;
    private String email;
    private Integer numtel;

    @ManyToMany(mappedBy="clients")
    private Collection<Voiture> voitures;

    @ManyToOne
    private Admine admin;
    @ManyToOne
    private Louer louer;
}
