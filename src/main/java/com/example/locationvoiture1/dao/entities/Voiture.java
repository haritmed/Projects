package com.example.locationvoiture1.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String matricule;
    private Integer model;
    private String marque;
    private String image;

    @ManyToMany
    private Collection<Client> clients=new ArrayList<>();

    @ManyToOne
    private Louer louer;


}

