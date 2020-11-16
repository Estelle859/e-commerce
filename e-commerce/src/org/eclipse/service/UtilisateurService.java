package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.model.Utilisateur;

public class UtilisateurService {
	private ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();

	public UtilisateurService() {
		utilisateurs.add(new Utilisateur(1, "wick","john", "client"));
		utilisateurs.add(new Utilisateur(2, "dalton","jack", "vendeur"));
		utilisateurs.add(new Utilisateur(3, "glou","mitro", "client"));
	}
	
	public Utilisateur findByNomAndPrenom(String nom, String prenom) {
		for(Utilisateur utilisateur: utilisateurs) {
			if(utilisateur.getNom().equals(nom) &&utilisateur.getPrenom().equals(prenom)) {
				return utilisateur;
			}
		}
		return null;
	}
}