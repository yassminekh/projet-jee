package model;

import javax.persistence.*;

@Entity
@Table(name = "enseignant")
public class Enseignant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String motDePasse;
    // Autres attributs et méthodes nécessaires

    // Constructeurs, getters et setters
}
