package org.eclipse.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.dao.LigneCommandeDao;
import org.eclipse.dao.LignePanierDao;
import org.eclipse.model.Categorie;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Produit;


public class LigneCommandeService {
	
	private LigneCommandeDao ligneCommandeDao = new LigneCommandeDao();

	public LigneCommandeService() {
		
//		lignes.add(new LigneCommande(new Produit(1, "Acer Aspire 5 Slim Laptop" , 359, 2, "https://images-na.ssl-images-amazon.com/images/I/71vvXGmdKWL._AC_SL1500_.jpg",true,new Categorie(1,"categorie1","description1")), 1));
//		lignes.add(new LigneCommande(new Produit(2, "Toshiba TF-55A810U21 55-inch ",260,8,"https://images-na.ssl-images-amazon.com/images/I/61xU%2BHbHJyL._AC_SL1000_.jpg",true,new Categorie(2,"categorie2","description2")), 2));
//		lignes.add(new LigneCommande(new Produit(3,"Canon PowerShot SX530 Digital Camera ",200,4,"https://images-na.ssl-images-amazon.com/images/I/61xeTmAQDNL._AC_SL1500_.jpg",true,new Categorie(3,"categorie3","description3")), 1));
//		
	}
	
	public LigneCommande save(LigneCommande ligne) {
		return ligneCommandeDao.save(ligne);
	}

	public List<LigneCommande> findAll() {
		return (List<LigneCommande>) ligneCommandeDao.findAll();
	}

	public void remove(int id) {
		ligneCommandeDao.remove(ligneCommandeDao.findById(id));
	}
	public LigneCommande findById(int id) {
		return ligneCommandeDao.findById(id);
	}
	public LigneCommande update(LigneCommande lp) {
		return ligneCommandeDao.update(lp);
		
	}
	public float getTotal() {
		float total = 0;
		List<LigneCommande> lignes = ligneCommandeDao.findAll();
		for(LigneCommande lc : lignes) {
			total += lc.getProduit().getPrixUnitaire() * lc.getQuantiteCommande();
		}
		return total;
	}

	public int getSize() {
		int nb = 0;
		List<LigneCommande> items =ligneCommandeDao.findAll();
		for(LigneCommande item : items) {
			nb+= item.getQuantiteCommande();
		}
		return nb;		
		//return lignes.size();
	}

}
