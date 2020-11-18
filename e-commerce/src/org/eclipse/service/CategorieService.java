package org.eclipse.service;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.model.Categorie;



public class CategorieService {
	private List<Categorie> categories = new ArrayList<>();

	public CategorieService() {
		categories.add(new Categorie(1, "Electronics", "desc"));
		categories.add(new Categorie(2, "Computer", "desc"));
		categories.add(new Categorie(3, "Art&Craft", "desc"));
		categories.add(new Categorie(4, "Smart Home", "desc"));
		categories.add(new Categorie(5, "Video Game", "desc"));
		
	}

	public void save(Categorie categorie) {
		categories.add(categorie);
	}

	public List<Categorie> findAll() {
		return categories;
	}

	public void remove(int id) {
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).getIdCate() == id) {
				categories.remove(i);
			}
		}
	}

}
