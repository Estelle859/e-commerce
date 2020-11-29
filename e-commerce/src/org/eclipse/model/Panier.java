package org.eclipse.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panier {

	private ArrayList<LigneCommande> lignes = new  ArrayList<LigneCommande>();
	
//	private int size;
//	private float total;
	
	public Panier() {
		
//		lignes.add(new LigneCommande(new Produit(1, "Acer Aspire 5 Slim Laptop" , 359, 1, "https://images-na.ssl-images-amazon.com/images/I/71vvXGmdKWL._AC_SL1500_.jpg",false,new Categorie(1,"categorie1","description1")), 1));
//		lignes.add(new LigneCommande(new Produit(2, "Toshiba TF-55A810U21 55-inch ",260,1,"https://images-na.ssl-images-amazon.com/images/I/61xU%2BHbHJyL._AC_SL1000_.jpg",true,new Categorie(2,"categorie2","description2")), 2));
//		lignes.add(new LigneCommande(new Produit(3,"Canon PowerShot SX530 Digital Camera ",200,4,"https://images-na.ssl-images-amazon.com/images/I/61xeTmAQDNL._AC_SL1500_.jpg",true,new Categorie(3,"categorie3","description3")), 3));
//		
	}	
	//ajouter aricle au panier
	public void addLigne(Produit produit,int quantite) {		
		LigneCommande ligneCommande = lignes.get(produit.getId());
		if(ligneCommande==null) {	
//			System.out.println("sur adding article null");
//			lignes.add(produit.getId(), new LigneCommande(produit,quantite));
			LigneCommande article = new LigneCommande();
			article.setProduit(produit);
			article.setQuantiteCommande(quantite);	
			//article.setP.setPrix(produit.getPrixUnitaire());		
			lignes.add(article);
		}else {
			System.out.println("adding article not null");	
			ligneCommande.setQuantiteCommande(ligneCommande.getQuantiteCommande()+quantite);
			System.out.println("quantite commande" + ligneCommande.getQuantiteCommande());
		}
	}
	public Collection<LigneCommande> getLignes(){
		return  lignes;
		
	}

	public float getTotal() {
		float total = 0;
		Collection<LigneCommande> lignes = getLignes();
		for(LigneCommande lc : lignes) {
			total += lc.getProduit().getPrixUnitaire() * lc.getQuantiteCommande();
		}
		return total;
	}

	public int getSize() {
//		int nb = 0;
//		Collection<LigneCommande> items = getLignes();
//		for(LigneCommande item : items) {
//			nb+= item.getQuantiteCommande();
//		}
//		return nb;		
		return lignes.size();
	}
	public void deleteLigne(int id) {
		lignes.remove(id);
	}
	
}

