package org.eclipse.model;

import org.eclipse.model.Produit;

public class ArticlePanier {
	
	private Long id;
	private Produit produit;
	private int quantite;
	
	public ArticlePanier() {
		super();
	}
	public ArticlePanier(Produit produit, int quantite) {
		super();
		this.produit = produit;
		this.quantite = quantite;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	@Override
	public String toString() {
		return "ArticlePanier [id=" + id + ", produit=" + produit + ", quantite=" + quantite + "]";
	}
	

}