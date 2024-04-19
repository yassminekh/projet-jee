package model;

import javax.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String motDePasse;
    
	public Administrateur(int id, String nom, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.motDePasse = motDePasse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	 // Méthode pour vérifier l'authentification de l'administrateur
    public boolean authenticate(String nom, String motDePasse) {
        return this.nom.equals(nom) && this.motDePasse.equals(motDePasse);
    }
}
