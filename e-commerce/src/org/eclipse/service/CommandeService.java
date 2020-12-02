package org.eclipse.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.model.Client;
import org.eclipse.model.Commande;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Panier;
import org.eclipse.model.Produit;
import org.eclipse.config.MyConnection;
import org.eclipse.dao.CommandeDao;
import org.eclipse.dao.LigneCommandeDao;
import org.eclipse.dao.ProduitDao;

public class CommandeService {
	private CommandeDao commandeDao = new CommandeDao();
	private ProduitDao produitDao = new  ProduitDao();

	public LigneCommande save(LigneCommande lp) {	
		
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT INTO lignecommande (quantiteCommande,produit,commande) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);				
				ps.setInt(1, lp.getQuantiteCommande());
				ps.setInt(2,lp.getProduit().getId());	
				ps.setInt(3, lp.getCommande().getId());
				System.out.println("produit in ligne = " +lp.getProduit().getId() );
				System.out.println("commande in ligne = " +lp.getProduit().getId() );
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					lp.setId(resultat.getInt(1));
					return lp;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}
	

	public void remove(LigneCommande lp) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM ligneCommande  WHERE idLigneCommande = ? ; ");
				ps.setInt(1,lp.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public LigneCommande update(LigneCommande lp) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE ligneCommande SET quantiteCommande=? WHERE idLigneCommande=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1,lp.getQuantiteCommande());
				ps.setInt(2,lp.getId());
			
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return lp;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public LigneCommande findById(int id) {
		
		Connection c = MyConnection.getConnection();
		
		ProduitDao produitDao = new ProduitDao();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from Panier ");
				;
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					Produit produit = produitDao.findById(result.getInt("produit"));
					Commande commande = commandeDao.findById(result.getInt("commande"));
					int quantite = result.getInt("quantiteCommande");
					//LigneCommande ligne = new LigneCommande(quantite , produit,commande);				
				//return ligne;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	public List<LignePanier> findAll() {
		Connection c = MyConnection.getConnection();
		ArrayList<LignePanier> lignePaniers = new ArrayList<LignePanier>();
		ProduitDao produitDao = new ProduitDao();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from lignePanier ");
				;
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					Produit produit = produitDao.findById(result.getInt("produit"));					
					int quantite = result.getInt("quantiteSelectionne");
					LignePanier ligne = new LignePanier(quantite , produit);
					lignePaniers.add(ligne);
					return lignePaniers;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	
	
	private List<Commande> cmds =  new ArrayList<>();
	public Commande enregistrementCommande(Panier panier, Client client) {
		Commande cmd = new Commande();
		cmd.setClient(client);
		cmd.setLignecommandes(panier.getLignes());
		return null;
		
	}

}
