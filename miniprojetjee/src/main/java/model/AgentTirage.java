package model;

import javax.persistence.*;

@Entity
@Table(name = "agent_tirage")
public class AgentTirage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String username;

    private String password;

	public AgentTirage(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	 // Méthode pour vérifier l'authentification de l'agent de tirage
    public boolean authenticate(String nom, String motDePasse) {
        return this.username.equals(nom) && this.password.equals(motDePasse);
    }
}
