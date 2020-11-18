package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private int idCate;
	private String nomCategorie;
	private String description;
	//private String urlImage;	
	//private List<Produit> produits = new ArrayList<Produit>();
	
	public Categorie() {
	
	}
	public Categorie(int id, String nomCategorie, String description) {
		super();
		this.idCate = id;
		this.nomCategorie = nomCategorie;
		this.description = description;
		//this.urlImage = urlImage;
		//this.produits = produits;
	}
	

	public int getIdCate() {
		return idCate;
	}
	public void setIdCate(int idCate) {
		this.idCate = idCate;
	}
	public String getNomCategorie() {
		return nomCategorie;
	}
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public String getUrlImage() {
//		return urlImage;
//	}
//	public void setUrlImage(String urlImage) {
//		this.urlImage = urlImage;
//	}
//	public List<Produit> getProduits() {
//		return produits;
//	}
//	public void setProduits(List<Produit> produits) {
//		this.produits = produits;
//	}
	@Override
	public String toString() {
		return "Categorie [id=" + idCate + ", nomCategorie=" + nomCategorie + ", description=" + description +  "]";
				  
	}
	

}

