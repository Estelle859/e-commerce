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


public class LignePanierService {

	private LignePanierDao lignePanierDao = new LignePanierDao();
	private List<LignePanier> lignes = new  ArrayList<>();

	public  LignePanierService() {

	}

	public LignePanier save(LignePanier ligne) {
		return lignePanierDao.save(ligne);
	}

	public List<LignePanier> findAll() {
		return (List<LignePanier>) lignePanierDao.findAll();
	}

	public void remove(int id) {
		lignePanierDao.remove(lignePanierDao.findById(id));
	}
	public LignePanier findById(int id) {
		return lignePanierDao.findById(id);
	}
	public LignePanier update(LignePanier lp) {
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
