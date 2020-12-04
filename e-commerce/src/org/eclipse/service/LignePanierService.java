package org.eclipse.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.dao.LignePanierDao;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Produit;


public class LignePanierService {

	private LignePanierDao lignePanierDao = new LignePanierDao();
	private List<LignePanier> lignes = new  ArrayList<>();

	public  LignePanierService() {

	}

	public LignePanier save(LignePanier ligne) {

		Produit produit = ligne.getProduit() ;
		System.out.println("product id of ligne panier " + produit);
		if(lignePanierDao.findByProduit(produit)==null) {
			System.out.println("save**"+ligne);		
			return lignePanierDao.save(ligne);
		}else {
			System.out.println("update**"+ligne);
			
			return lignePanierDao.updateAddQuantite(ligne);
		}
		
	}

	public List<LignePanier> findAll() {
		return (List<LignePanier>) lignePanierDao.findAll();
	}

	public void remove(int id) {
		System.out.println(lignePanierDao.findById(id));
		lignePanierDao.remove(lignePanierDao.findById(id));
	}
	public LignePanier findById(int id) {
		return lignePanierDao.findById(id);
	}
	public LignePanier update(LignePanier lp) {
		System.out.println("update article " + lp.getId());
		return lignePanierDao.update(lp);
		
	}
	
	public float getTotal() {
		float total = 0;
		Collection<LignePanier> lignes = lignePanierDao.findAll();
		for(LignePanier lc : lignes) {
			total += lc.getProduit().getPrixUnitaire() * lc.getQuantiteSelectionne();
		}
		return total;
	}

	public int getSize() {
		int nb = 0;
		Collection<LignePanier> items =lignePanierDao.findAll();
		for(LignePanier item : items) {
			nb+= item.getQuantiteSelectionne();
		}
		return nb;		
		//return lignes.size();
	}
	

}
