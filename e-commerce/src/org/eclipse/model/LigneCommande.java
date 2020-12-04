package org.eclipse.model;
public class LigneCommande {
	
	private int id;
	private int quantiteCommande;	
	private Produit produit;
	private Float prix;
	
	public LigneCommande() {
	
	}

	public LigneCommande(int id) {
	
		this.id = id;
	}

	public LigneCommande(int quantiteCommande, Produit produit, Float prix) {
	
		this.quantiteCommande = quantiteCommande;
		this.produit = produit;
		this.prix = prix;
	}
	

	public LigneCommande(int id, int quantiteCommande, Produit produit, Float prix) {

		this.id = id;
		this.quantiteCommande = quantiteCommande;
		this.produit = produit;
		this.prix = prix;
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

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantiteCommande=" + quantiteCommande + ", produit=" + produit + ", prix="
				+ prix + "]";
	}

	
	
}

