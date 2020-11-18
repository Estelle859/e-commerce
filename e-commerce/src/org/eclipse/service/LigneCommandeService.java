package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Categorie;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.Produit;


public class LigneCommandeService {
	
	private ArrayList<LigneCommande> lignes = new ArrayList<>();

	public LigneCommandeService() {
		
		lignes.add(new LigneCommande(new Produit(1, "Acer Aspire 5 Slim Laptop" , 359, 2, "https://images-na.ssl-images-amazon.com/images/I/71vvXGmdKWL._AC_SL1500_.jpg",true,new Categorie(1,"categorie1","description1")), 1));
		lignes.add(new LigneCommande(new Produit(2, "Toshiba TF-55A810U21 55-inch ",260,8,"https://images-na.ssl-images-amazon.com/images/I/61xU%2BHbHJyL._AC_SL1000_.jpg",true,new Categorie(2,"categorie2","description2")), 2));
		lignes.add(new LigneCommande(new Produit(3,"Canon PowerShot SX530 Digital Camera ",200,4,"https://images-na.ssl-images-amazon.com/images/I/61xeTmAQDNL._AC_SL1500_.jpg",true,new Categorie(3,"categorie3","description3")), 1));
	}

	public void save(LigneCommande lc) {
		lignes.add(lc);
	}

	public ArrayList<LigneCommande> findAll() {
		return lignes;
	}

	public void remove(int id) {
		for (int i = 0; i < lignes.size(); i++) {
			if (lignes.get(i).getId() == id) {
				lignes.remove(i);
			}
		}
	}

}
