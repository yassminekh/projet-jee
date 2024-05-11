package model;

public class Administrateur {
    private int idAdmin;
    private String username;
    private String email;
    private String password;

    public Administrateur( String username, String email,String password) {
        
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
   

    public String getUsername() {
        return username;
    }

    public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
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
