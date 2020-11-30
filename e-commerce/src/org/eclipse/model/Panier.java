package org.eclipse.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panier {
	private int id;
	private ArrayList<LignePanier> lignes = new  ArrayList<LignePanier>();	
	private Utilisateur utilisateur;
	
	public Panier() {		
//		lignes.add(new LigneCommande(new Produit(1, "Acer Aspire 5 Slim Laptop" , 359, 1, "https://images-na.ssl-images-amazon.com/images/I/71vvXGmdKWL._AC_SL1500_.jpg",false,new Categorie(1,"categorie1","description1")), 1));
//		lignes.add(new LigneCommande(new Produit(2, "Toshiba TF-55A810U21 55-inch ",260,1,"https://images-na.ssl-images-amazon.com/images/I/61xU%2BHbHJyL._AC_SL1000_.jpg",true,new Categorie(2,"categorie2","description2")), 2));
//		lignes.add(new LigneCommande(new Produit(3,"Canon PowerShot SX530 Digital Camera ",200,4,"https://images-na.ssl-images-amazon.com/images/I/61xeTmAQDNL._AC_SL1500_.jpg",true,new Categorie(3,"categorie3","description3")), 3));
//		
	}	
	public Panier(int id) {

		this.id = id;
	}
	public Panier(ArrayList<LignePanier> lignes) {

		this.lignes = lignes;
	}
	public Panier(int id, ArrayList<LignePanier> lignes) {

		this.id = id;
		this.lignes = lignes;
	}
	
	
	public Panier(int id, ArrayList<LignePanier> lignes, Utilisateur utilisateur) {
	
		this.id = id;
		this.lignes = lignes;
		this.utilisateur = utilisateur;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLignes(ArrayList<LignePanier> lignes) {
		this.lignes = lignes;
	}
		
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public ArrayList<LignePanier> getLignes() {
		return lignes;
	}
	@Override
	public String toString() {
		return "Panier [id=" + id + ", lignes=" + lignes + ", utilisateur=" + utilisateur + "]";
	}
	

}

