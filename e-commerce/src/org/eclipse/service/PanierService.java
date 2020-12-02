package org.eclipse.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.model.LignePanier;
import org.eclipse.model.Panier;
import org.eclipse.model.Produit;

public class PanierService {
	
//	private List<LignePanier> lignes = new  ArrayList<>();	
//
//	public void addLigne(Produit produit,int quantite) {	
//		
//		LignePanier ligne = lignes.get(produit.getId());		
//		if(ligne==null) {
//			LignePanier article = new LignePanier();
//			article.setProduit(produit);
//			article.setQuantiteSelectionne(quantite);				
//			lignes.add(article);
//		}else {
//	
//			ligne.setQuantiteSelectionne(ligne.getQuantiteSelectionne()+quantite);
//
//		}
//	}
//	public Collection<LignePanier> getLignes(){
//		return  lignes;
//		
//	}
//
//	public float getTotal() {
//		float total = 0;
//		Collection<LignePanier> lignes = getLignes();
//		for(LignePanier lc : lignes) {
//			total += lc.getProduit().getPrixUnitaire() * lc.getQuantiteSelectionne();
//		}
//		return total;
//	}
//
//	public int getSize() {
//		int nb = 0;
//		Collection<LignePanier> items = getLignes();
//		for(LignePanier item : items) {
//			nb+= item.getQuantiteSelectionne();
//		}
//		return nb;		
//		//return lignes.size();
//	}
//	public void deleteLigne(int id) {
//		lignes.remove(id);
//	}
//	public Panier findByIdLigne(int idD) {
//			return null;
//	}
//	

}
