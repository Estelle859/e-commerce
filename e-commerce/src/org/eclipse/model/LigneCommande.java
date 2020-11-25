package org.eclipse.model;
public class LigneCommande {
	
	private int quantiteCommande;	
	private Produit produit;
	
	//private float prix;
	
	public LigneCommande() {
		//new LigneCommande(new Produit(2, "Toshiba TF-55A810U21 55-inch ",260,8,"https://images-na.ssl-images-amazon.com/images/I/61xU%2BHbHJyL._AC_SL1000_.jpg",true,new Categorie(2,"categorie2","description2")), 2);
	}

	public LigneCommande(Produit p, int qte) {	
		this.produit = p;
		this.quantiteCommande = qte;
				
	}
//	public LigneCommande(int id, int quantite, Produit produit float prix) {	
//		this.id = id;
//		this.quantiteCommande = quantite;
//		this.produit = produit;
//		//this.prix = prix;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
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

//	public float getPrix() {			
//		return prix;
//	}
//		
//	public void setPrix(float prix) {
//		this.prix = prix;
//	}

	public String toString() {
		return "LigneCommande [ quantite=" + quantiteCommande + ", produit=" + produit  + "]";
	}
	


}

