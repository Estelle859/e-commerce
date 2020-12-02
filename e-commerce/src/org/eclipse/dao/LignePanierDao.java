package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Adresse;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Produit;
import org.eclipse.model.Utilisateur;


public class LignePanierDao implements Dao<LignePanier> {
	private ProduitDao produitDao = new  ProduitDao();
	@Override
	public LignePanier save(LignePanier lp) {	
		
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT INTO lignepanier (quantiteSelectionne,produit) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);				
				ps.setInt(1, lp.getQuantiteSelectionne());
				ps.setInt(2,lp.getProduit().getId());	
				
				System.out.println("produit in ligne = " +lp.getProduit().getId() );
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
	

	@Override
	public void remove(LignePanier lp) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM lignePanier  WHERE idLignePanier = ? ; ");
				ps.setInt(1,lp.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public LignePanier update(LignePanier lp) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE lignePanier SET quantiteSelectionne=? WHERE idLignePanier=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1,lp.getQuantiteSelectionne());
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
	@Override
	public LignePanier findById(int id) {
		
		Connection c = MyConnection.getConnection();
		
		ProduitDao produitDao = new ProduitDao();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("select * from Panier ");
				;
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					Produit produit = produitDao.findById(result.getInt("produit"));	
					int quantite = result.getInt("quantiteSelectionne");
					LignePanier ligne = new LignePanier(quantite , produit);				
					return ligne;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

//	@Override
//	public LignePanier findById(int id) {
//		Connection c = MyConnection.getConnection();
//		if (c != null) {
//			try {
//				PreparedStatement ps = c.prepareStatement("SELECT * FROM lignepanier WHERE idLignePanier = ?;");
//				ps.setInt(1, id);
//				ResultSet rs = ps.executeQuery();
//				if (rs.next()) {
//					LignePanier lp = new LignePanier();
//					lp.setId(rs.getInt("idLignePanier"));
//					lp.setQuantiteSelectionne(rs.getInt("quantiteSelectionne"));
//					lp.getProduit().setId(rs.getInt("idProduit"));	
//					lp.getProduit().setDesignation(rs.getString("designation"));
//					lp.getProduit().setPrixUnitaire(rs.getFloat("prixUnitaire"));
//					lp.getProduit().setQuantiteStock(rs.getInt("quantiteStock"));				
//					return lp; 
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return null;
//	}



	
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


}
