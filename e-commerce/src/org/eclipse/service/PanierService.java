package org.eclipse.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.model.Categorie;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.Panier;
import org.eclipse.model.Produit;

public class PanierService {
	private List<LigneCommande> lignes = new  ArrayList<>();	

	public PanierService() {	
		
	}
	public void addItems(Produit produit,int quantite) {		
		LigneCommande ligneCommande = lignes.get(produit.getId());
		if(ligneCommande==null) {	
			LigneCommande article = new LigneCommande();
			article.setProduit(produit);
			article.setQuantite(quantite);	
			article.setPrix(produit.getPrixUnitaire());		
			lignes.add(article);
		}else {
			ligneCommande.setQuantite(ligneCommande.getQuantite()+quantite);
		}
	}
	public Collection<LigneCommande> getItems(){
		return  lignes;
		
	}
	public int getSize() {
		int nb = 0;
		Collection<LigneCommande> items = getItems();
		for(LigneCommande item : items) {
			nb+= item.getQuantite();
		}
		return nb;
		
	}
	public float getTotal() {
		float total = 0;
		for(LigneCommande lc : lignes) {
			total += lc.getPrix() * lc.getQuantite();
		}
		return total;
	}
	public void deleteItems(Long id) {
		lignes.remove(id);
	}

}
