package org.eclipse.model;
public class LigneCommande {
	
	private int id;
	private int quantiteCommande;	
	private Produit produit;
	private Commande commande;
	private Float prix;
	
	public LigneCommande(int quantiteCommande, Produit produit, Commande commande, Float prix) {
		super();
		this.quantiteCommande = quantiteCommande;
		this.produit = produit;
		this.commande = commande;
		this.prix = prix;
	}

	public LigneCommande(int id, int quantiteCommande, Produit produit, Commande commande, Float prix) {
		super();
		this.id = id;
		this.quantiteCommande = quantiteCommande;
		this.produit = produit;
		this.commande = commande;
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

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantiteCommande=" + quantiteCommande + ", produit=" + produit
				+ ", commande=" + commande + ", prix=" + prix + "]";
	}
	
	
}

