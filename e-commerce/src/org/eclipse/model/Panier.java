package org.eclipse.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier {
	
	private Map<Long,LigneCommande> ligneCommandes = new HashMap<Long,LigneCommande>();
	//private Map<Long,ArticlePanier> articles = new HashMap<Long,ArticlePanier>();
	
	
	public void addItems(Produit produit,int quantite) {		
		LigneCommande ligneCommande = ligneCommandes.get(produit.getId());
		if(ligneCommande==null) {	
			ligneCommande.setProduit(produit);
			ligneCommande.setQuantite(ligneCommande.getQuantite() + quantite);	
			ligneCommande.setPrix(produit.getPrixUnitaire());
			//ligneCommandes.put(produit.getId(), ligneCommande);
			ligneCommandes.put(produit.getId(), new LigneCommande(produit,quantite));
		}else {
			ligneCommande.setQuantite(produit.getQuantite()+quantite);
		}
	}
	public Collection<LigneCommande> getItems(){
		return  ligneCommandes.values();
		
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
		for(LigneCommande lc : ligneCommandes.values()) {
			total += lc.getPrix() * lc.getQuantite();
		}
		return total;
	}
	public void deleteItems(Long id) {
		ligneCommandes.remove(id);
	}
	@Override
	public String toString() {
		return "Panier [ligneCommandes=" + ligneCommandes  + "]";
	}
	
}

