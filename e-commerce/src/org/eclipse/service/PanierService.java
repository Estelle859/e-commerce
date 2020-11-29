package org.eclipse.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.model.Categorie;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.Produit;

public class PanierService {
	
private List<LigneCommande> lignes = new  ArrayList<LigneCommande>();	

	public void addLigne(Produit produit,int quantite) {	
			
		//LigneCommande ligneCommande = lignes.get(produit.getId());
		//System.out.println("ligne commmande " + ligneCommande);
		
	//	if(ligneCommande==null) {
			LigneCommande article = new LigneCommande();
			article.setProduit(produit);
			article.setQuantiteCommande(quantite);				
			lignes.add(article);
	//	}else {
//			System.out.println("adding article not null");	
//			ligneCommande.setQuantiteCommande(ligneCommande.getQuantiteCommande()+quantite);
//			System.out.println("quantite commande" + ligneCommande.getQuantiteCommande());
	//}
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
