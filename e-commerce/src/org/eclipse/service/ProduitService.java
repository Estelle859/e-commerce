package org.eclipse.service;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.dao.ProduitDao;
import org.eclipse.model.Categorie;
import org.eclipse.model.Produit;


public class ProduitService {
	
	List<Produit> produits = new ArrayList<>();
	private ProduitDao produitDao = new ProduitDao();
	//Categorie categorie1,categorie2,categorie3,ctegorie4; 	
	
	public ProduitService() {	
//		 produits.add(new Produit(1, "Acer Aspire 5 Slim Laptop" , 359, 2, "https://images-na.ssl-images-amazon.com/images/I/71vvXGmdKWL._AC_SL1500_.jpg",true,new Categorie(1,"categorie1","description1")));
//		 produits.add(new Produit(2, "Toshiba TF-55A810U21 55-inch ",260,8,"https://images-na.ssl-images-amazon.com/images/I/61xU%2BHbHJyL._AC_SL1000_.jpg",true,new Categorie(2,"categorie2","description2")));
//		 produits.add(new Produit(3,"Canon PowerShot SX530 Digital Camera ",200,4,"https://images-na.ssl-images-amazon.com/images/I/61xeTmAQDNL._AC_SL1500_.jpg",true,new Categorie(3,"categorie3","description3")));								
//		 produits.add(new Produit(4,"Samsung Galaxy S20 FE 5G",599,6,"https://images-na.ssl-images-amazon.com/images/I/712PXMEDp4L._AC_SL1500_.jpg",true,new Categorie(4,"categorie","description4")));	

	}

	public Produit save(Produit produit) {
		return produitDao.save(produit);
	}

	public ArrayList<Produit> findAll() {
		return (ArrayList<Produit>) produitDao.findAll();
	}

	public void remove(int id) {
		produitDao.remove(produitDao.findById(id));
	}	
		
	public void removeByProduct(Produit produit) {
		produitDao.remove(produit);
	}
	
	public Produit findByIdProduct(int num) {
		return produitDao.findById(num);
	}
	public Produit update(Produit produit) {
		return produitDao.update(produit);
		
	}


	public List<Produit> produitSelectionnes() {
//		List<Produit> sellectionnes = new ArrayList<>();
//		for (Produit produit : produits) {
//            if (produit.isSelectionne()==true) {
//            	sellectionnes.add(produit);
//            }
//        }
		return produitDao.produitSelectionnes();		
	}	

//	public List<Produit> getAllProductsByCategorie(Long idCategorie) {
////		  ArrayList<Produit> produitsparCategorie = new ArrayList<>();	
////		for(Produit p : produits) {
////			if(idCategorie==p.getCategorie().getIdCate()) {
////				produitsparCategorie.add(p);
////			}
////		}
////        return produitsparCategorie;
//    }

}