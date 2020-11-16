package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

public class Vendeur {
	
	private List<Produit> produits = new ArrayList<>();
	
	
	public Vendeur() {
		super();
	}
	public Vendeur(List<Produit> produits) {
		super();
		this.produits = produits;
	}
	
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
}