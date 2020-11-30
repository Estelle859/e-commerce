package org.eclipse.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.dao.LignePanierDao;
import org.eclipse.model.LignePanier;


public class LignePanierService {

	private LignePanierDao lignePanierDao = new LignePanierDao();

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
	

}
