package org.eclipse.model;

public class Utilisateur {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String telephone;
	private String type;
	//private List<Adresse> adresses = new ArrayList<>();
	
	public Utilisateur() {
		
	}

	public Utilisateur(int id) {
	
		this.id = id;
	}

	public Utilisateur(String email, String password) {
	
		this.email = email;
		this.password = password;
	}


	public Utilisateur(int id, String nom, String prenom, String email, String password, String telephone, String type) {

		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.type = type;		
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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", password="
				+ password + ", telephone=" + telephone + ", type=" + type + "]";
	}
	
	

}
