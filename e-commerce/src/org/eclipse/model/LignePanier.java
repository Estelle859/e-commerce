package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

public class LignePanier {
	
	private int id;
	private int quantiteSelectionne;	
	private Produit produit;
	private Panier panier;

	private List<Produit> produits = new ArrayList<>();
	
	public LignePanier() {
	
	}

	public LignePanier(int id) {
	
		this.id = id;
	}



	public LignePanier(int id, int quantiteSelectionne) {
		
		this.id = id;
		this.quantiteSelectionne = quantiteSelectionne;

	}
	

	public LignePanier(int quantiteSelectionne, Produit produit) {
	
		this.quantiteSelectionne = quantiteSelectionne;
		this.produit = produit;
	}

	public LignePanier(int id, int quantiteSelectionne, List<Produit> produits) {
	
		this.id = id;
		this.quantiteSelectionne = quantiteSelectionne;
		this.produits = produits;
	}
	
	
	public LignePanier(int quantiteSelectionne, Produit produit, Panier panier) {

		this.quantiteSelectionne = quantiteSelectionne;
		this.produit = produit;
		this.panier = panier;
	}

	public LignePanier(int id, int quantiteSelectionne, Produit produit, Panier panier) {

		this.id = id;
		this.quantiteSelectionne = quantiteSelectionne;
		this.produit = produit;
		this.panier = panier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantiteSelectionne() {
		return quantiteSelectionne;
	}

	public void setQuantiteSelectionne(int quantiteSelectionne) {
		this.quantiteSelectionne = quantiteSelectionne;
	}
	

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "LignePanier [id=" + id + ", quantiteSelectionne=" + quantiteSelectionne + ", produit=" + produit + "]";
	}

	

}
