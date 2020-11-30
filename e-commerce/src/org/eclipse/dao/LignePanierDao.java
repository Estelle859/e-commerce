package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.LignePanier;


public class LignePanierDao implements Dao<LignePanier> {

	@Override
	public LignePanier save(LignePanier lp) {
		
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT INTO lignepanier (quantiteSelectionne,produit) values (?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);				
				ps.setInt(1, lp.getQuantiteSelectionne());
				ps.setInt(2,lp.getProduit().getId());	
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
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM lignepanier WHERE idLignePanier = ?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int idL = result.getInt(1);					
					int quantiteSelectionne = result.getInt(2);
				
					LignePanier lp = new LignePanier(idL,quantiteSelectionne);
					return lp;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<LignePanier> findAll() {
		List<LignePanier> lps = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM lignepanier;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int idL = result.getInt(1);					
					int quantiteSelectionne = result.getInt(2);				
					LignePanier lp = new LignePanier(idL,quantiteSelectionne);
					lps.add(lp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lps;
	}

	

}
