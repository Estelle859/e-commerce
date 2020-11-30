package org.eclipse.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.dao.UtilisateurDao;
import org.eclipse.model.Utilisateur;


public class UtilisateurService {
	
	private UtilisateurDao userDao = new UtilisateurDao();
	
	public Utilisateur save(Utilisateur user) {
		user.setNom(user.getNom().toUpperCase());
		return userDao.save(user);
	}
	public Utilisateur update(Utilisateur user) throws Exception {
		if (userDao.findById(user.getId()) == null) {
			throw new Exception("Utilsateur introuvable");		
		}
		user.setNom(user.getNom().toUpperCase());
		return userDao.update(user);
	}
	public void remove(Utilisateur user) throws Exception {
		if (userDao.findById(user.getId()) == null) {
			throw new Exception("Utilisateur introuvable");		
		}	
		userDao.remove(user);
	}
	public List<Utilisateur> findAll() {		
		return userDao.findAll();	
		
	}
	public Utilisateur findById(int id) {
		return userDao.findById(id);		
	}
	public Utilisateur findByUserLogin(String userName, String password) {		
		return userDao.findByUserLogin(userName, password);
	}
}