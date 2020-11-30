package org.eclipse.model;
public class LigneCommande {
	
	private int id;
	private int quantiteCommande;	
	private Produit produit;
	
	public LigneCommande() {
		
	}

	public LigneCommande(int id) {
	
		this.id = id;
	}

	
	public LigneCommande(int id, int quantiteCommande) {
	
		this.id = id;
		this.quantiteCommande = quantiteCommande;
	}
	

	public LigneCommande(int quantiteCommande, Produit produit) {
		super();
		this.quantiteCommande = quantiteCommande;
		this.produit = produit;
	}

	public LigneCommande(int id, int quantiteCommande, Produit produit) {
		super();
		this.id = id;
		this.quantiteCommande = quantiteCommande;
		this.produit = produit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantiteCommande() {
		return quantiteCommande;
	}

	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}
	

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantiteCommande=" + quantiteCommande + "]";
	}

}

