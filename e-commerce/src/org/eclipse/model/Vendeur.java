package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

public class Vendeur {
	private int id;
	private String nom;
	private String prenom;
	private List<Adresse> adresses = new ArrayList<>();
	private String email;
	private String telephone;	
	private List<Produit> produits = new ArrayList<>();
	
	public Vendeur() {
		
	}
	

	public Vendeur(int id) {

		this.id = id;
	}
	public Vendeur(String nom, String prenom) {	
		this.nom = nom;
		this.prenom = prenom;		
	}
	public Vendeur(String nom, String prenom, String email, String telephone) {	
		this.nom = nom;
		this.prenom = prenom;	
		this.email = email;
		this.telephone = telephone;
	}		

	public Vendeur(int id, String nom, String prenom,  List<Adresse> adresses,String email, String telephone) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresses = adresses;
		this.email = email;
		this.telephone = telephone;
		this.produits = produits;
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


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}


	@Override
	public String toString() {
		return "Vendeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresses=" + adresses + ", email="
				+ email + ", telephone=" + telephone + ", produits=" + produits + "]";
	}

		
}