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
    // Autres attributs et m�thodes n�cessaires

    // Constructeurs, getters et setters
}
