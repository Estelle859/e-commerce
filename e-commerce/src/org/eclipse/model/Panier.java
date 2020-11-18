package org.eclipse.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Panier {
	
	private List<LigneCommande> lignes = new  ArrayList<>();	

	public Panier(List<LigneCommande> lignes) {
		super();
		this.lignes = lignes;
	}
	
	public List<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	
	@Override
	public String toString() {
		return "Panier [ligneCommandes=" + lignes  + "]";
	}
	
}

