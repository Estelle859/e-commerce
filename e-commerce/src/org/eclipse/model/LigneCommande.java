package org.eclipse.model;
public class LigneCommande {
	
	private int quantiteCommande;	
	private Produit produit;
	
	public LigneCommande() {
		
	}

	public LigneCommande(Produit p, int qte) {	
		this.produit = p;
		this.quantiteCommande = qte;
				
	}

	public int getQuantiteCommande() {
		return quantiteCommande;
	}
	public void setQuantiteCommande(int quantite) {
		this.quantiteCommande = quantite;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public String toString() {
		return "LigneCommande [ quantite=" + quantiteCommande + ", produit=" + produit  + "]";
	}
	


}

