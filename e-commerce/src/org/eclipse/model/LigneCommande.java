package org.eclipse.model;
public class LigneCommande {
	
	private int id;
	private int quantite;	
	private Produit produit;
	
	private float prix;
	
	public LigneCommande() {
		super();
	}

	public LigneCommande(Produit p, int qte) {
		this.produit = p;
		this.quantite = qte;
				
	}
	public LigneCommande(int id, int quantite, Produit produit, float prix) {	
		this.id = id;
		this.quantite = quantite;
		this.produit = produit;
		this.prix = prix;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public float getPrix() {			
		return prix;
	}
		
	public void setPrix(float prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", quantite=" + quantite + ", produit=" + produit + ", prix=" + prix + "]";
	}
	


}

