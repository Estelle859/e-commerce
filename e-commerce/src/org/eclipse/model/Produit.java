package org.eclipse.model;

import org.eclipse.model.Categorie;

public class Produit {
	
	private int id;
	private String designation;
	private float prixUnitaire;
	private int quantiteStock;
	private String urlImage;
	private boolean selectionne;
	private Categorie categorie;
	
	public Produit() {
		categorie =  new Categorie();
	}
	public Produit(int i, String designation, float prixUnitaire, int quantite, String urlImage, boolean selectionne,
			Categorie categorie) {		
		this.id = i;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.quantiteStock = quantite;
		this.urlImage = urlImage;
		this.selectionne = selectionne;
		//this.categorie = categorie;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public float getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(int quantite) {
		this.quantiteStock = quantite;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public boolean isSelectionne() {
		return selectionne;
	}
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prixUnitaire=" + prixUnitaire + ", quantite="
				+ quantiteStock + ", urlImage=" + urlImage + ", selectionne=" + selectionne + ", categorie=" + categorie
				+ "]";
	}
}
