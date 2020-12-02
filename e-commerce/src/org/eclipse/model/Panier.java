package org.eclipse.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panier {
	private List<LigneCommande> lignes = new  ArrayList<>();	

	public void addLigne(Produit produit,int quantite) {	
		
		LigneCommande ligne = lignes.get(produit.getId());		
		if(ligne==null) {
			LigneCommande article = new LigneCommande();
			article.setProduit(produit);
			article.setQuantiteCommande(quantite);				
			lignes.add(article);
		}else {
	
			ligne.setQuantiteCommande(ligne.getQuantiteCommande()+quantite);

		}
	}
	public List<LigneCommande> getLignes(){
		return  lignes;
		
	}

	public float getTotal() {
		float total = 0;
		List<LigneCommande> lignes = getLignes();
		for(LigneCommande lc : lignes) {
			total += lc.getProduit().getPrixUnitaire() * lc.getQuantiteCommande();
		}
		return total;
	}

	public int getSize() {
		int nb = 0;
		List<LigneCommande> items = getLignes();
		for(LigneCommande item : items) {
			nb+= item.getQuantiteCommande();
		}
		return nb;		
		//return lignes.size();
	}
	public void deleteLigne(int id) {
		lignes.remove(id);
	}
	public Panier findByIdLigne(int idD) {
			return null;
	}
	

}

