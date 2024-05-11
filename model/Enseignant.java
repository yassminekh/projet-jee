package model;

public class Enseignant {
	private int idEnseigant;
	private String username;
	private String email;
	private String password;

	public Enseignant(String username, String email, String password) {

		this.username = username;
		this.email = email;
		this.password = password;
	}
	public Enseignant() {
	    // Constructeur par défaut vide
	}

	// Getters and setters

	public String getUsername() {
		return username;
	}

	public int getIdEnseigant() {
		return idEnseigant;
	}

	public void setIdEnseigant(int idEnseigant) {
		this.idEnseigant = idEnseigant;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
