package org.eclipse.model;

import java.util.ArrayList;
import java.util.List;

public class Adresse {
	private int id;
	private String rue;
	private String codePostal;
	private String ville;
	private List<Utilisateur> utilisateurs = new ArrayList<>();
	public Adresse() {
	}
	public Adresse(int id) {
		this.id = id;
	}
	public Adresse(String rue, String codePostal, String ville, List<Utilisateur>utilisateurs) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.utilisateurs = utilisateurs;
	}
	public Adresse(int id, String rue, String codePostal, String ville, List<Utilisateur> personnes) {
		this.id = id;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.utilisateurs = utilisateurs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public List<Utilisateur> getUtilisateur() {
		return utilisateurs;
	}
	public void setPersonnes(ArrayList<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", personnes="
				+ utilisateurs + "]";
	}
}