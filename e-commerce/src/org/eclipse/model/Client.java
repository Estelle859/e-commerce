package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	private String nom;
	private String prenom;
	private List<Adresse> adresses = new ArrayList<>();
	private String email;
	private String telephone;
	
	public Client() {
		super();
	}

	public Client(Long id, String userNom, String motDePasse, String nom, String prenom, List<Adresse> adresses,
			String email, String telephone) {
	
		this.nom = nom;
		this.prenom = prenom;
		this.adresses = adresses;
		this.email = email;
		this.telephone = telephone;
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

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresses=" + adresses + ", email=" + email
				+ ", telephone=" + telephone + "]";
	}


		

}
