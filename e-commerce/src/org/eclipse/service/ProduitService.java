package org.eclipse.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.model.Categorie;
import org.eclipse.model.Produit;


public class ProduitService {
	
	List<Produit> produits = new ArrayList<>();
	Categorie categorie1,categorie2,categorie3,ctegorie4; 
	
	
	public ProduitService() {	

		 produits.add(new Produit(1, "Acer Aspire 5 Slim Laptop" , 359, 2, "https://images-na.ssl-images-amazon.com/images/I/71vvXGmdKWL._AC_SL1500_.jpg",true,new Categorie(1,"categorie1","description1")));
		 produits.add(new Produit(2, "Toshiba TF-55A810U21 55-inch ",260,8,"https://images-na.ssl-images-amazon.com/images/I/61xU%2BHbHJyL._AC_SL1000_.jpg",true,new Categorie(2,"categorie2","description2")));
		 produits.add(new Produit(3,"Canon PowerShot SX530 Digital Camera ",200,4,"https://images-na.ssl-images-amazon.com/images/I/61xeTmAQDNL._AC_SL1500_.jpg",true,new Categorie(3,"categorie3","description3")));								
		 produits.add(new Produit(4,"Samsung Galaxy S20 FE 5G",599,6,"https://images-na.ssl-images-amazon.com/images/I/712PXMEDp4L._AC_SL1500_.jpg",true,new Categorie(4,"categorie","description4")));	

	}
	public void saveProduct(Produit produit) {	
		produits.add(produit);		
	}	
	public void removeProduct(Produit produit) {
		produits.remove(produit);
	}
//	public void removeById(int id) {
//		for(Produit produit : produits) {
//			if(produit.getId()==id) {
//				produits.remove(produit);
//			}			
//		}		
//	}
	public void removeById(int id) {
		for (int i = 0; i < produits.size(); i++) {
			if (produits.get(i).getId() == id) {
				produits.remove(i);
			}
		}
		
	}
	public void updateProduct(Produit produit) {	
		System.out.println("product id " + produit.getId());
		for (int i = 0; i < produits.size(); i++) {
			if (produits.get(i).getId() ==  produit.getId()) {
				produits.get(i).setDesignation(produit.getDesignation());
				//produits.get(i).getCategorie().setNomCategorie(produit.getCategorie().getNomCategorie());			
				Categorie categorie = produit.getCategorie();
				produits.get(i).getCategorie().setIdCate(categorie.getIdCate());
				produits.get(i).getCategorie().setNomCategorie(categorie.getNomCategorie());
				produits.get(i).getCategorie().setDescription(categorie.getDescription());
				
				produits.get(i).setQuantite(produit.getQuantite());
				produits.get(i).setPrixUnitaire(produit.getPrixUnitaire());
				produits.get(i).setUrlImage(produit.getUrlImage());	
				
			}
		}
		for(Produit p : produits) {		
			if(p.getId()==produit.getId()) {				
//				p.setDesignation(produit.getDesignation());
//				p.setQuantite(produit.getQuantite());
//				p.setPrixUnitaire(produit.getPrixUnitaire());
//				p.setUrlImage(produit.getUrlImage());				
			
				
				p = produit;
			}
		}		
	}	
	public List<Produit> getAllProducts() {
        return produits;
    }
	public void  setAllProducts(List<Produit> listeproduits) {
        produits = listeproduits;
    }
//	public List<Produit> getAllProductsByCategorie(Long idCategorie) {
//		  ArrayList<Produit> produitsparCategorie = new ArrayList<>();	
//		for(Produit p : produits) {
//			if(idCategorie==p.getCategorie().getId()) {
//				produitsparCategorie.add(p);
//			}
//		}
//        return produitsparCategorie;
//    }
	
	public Produit findByIdProduct(int num) {
		for(Produit p : produits) {
			if(num == p.getId()) return p;
		}
		return null;
	}
	public Produit findByDesignProduct(String produitDesign) {
		for(Produit p : produits) {
			if(produitDesign == p.getDesignation()) return p;
		}	
		return null;
	}
	
	public List<Produit> findByQuantiteEnStock() {
        List<Produit> disponibles = new ArrayList<>();
        for (Produit produit : produits) {
            if (produit.getQuantite() > 0) {
                disponibles.add(produit);
            }
        }
        return disponibles;
	}
	public List<Produit> produitSelectionnes() {
		List<Produit> sellectionnes = new ArrayList<>();
		for (Produit produit : produits) {
            if (produit.isSelectionne()==true) {
            	sellectionnes.add(produit);
            }
        }
		return sellectionnes;
		
	}
	

}