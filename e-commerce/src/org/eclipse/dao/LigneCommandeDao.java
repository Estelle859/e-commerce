package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.LigneCommande;

public class LigneCommandeDao implements Dao<LigneCommande> {
	@Override
	public LigneCommande save(LigneCommande lc) {
		
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT INTO ligneCommande (quantiteCommande) values (?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);				
				ps.setInt(1, lc.getQuantiteCommande());		
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					lc.setId(resultat.getInt(1));
					return lc;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public void remove(LigneCommande lc) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM ligneCommande  WHERE idLigneCommande = ? ; ");
				ps.setInt(1,lc.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public LigneCommande update(LigneCommande lc) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("UPDATE  ligneCommande SET quantiteCommande=? WHERE idLigneCommande=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setInt(1,lc.getQuantiteCommande());
				ps.setInt(2,lc.getId());
			
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return lc;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public LigneCommande findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM ligneCommande WHERE idLigneCommande = ?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int idC = result.getInt(1);					
					int quantiteCommande = result.getInt(2);
				
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<LigneCommande> findAll() {
		List<LigneCommande> lcs = new ArrayList<>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM ligneCommande;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int idC = result.getInt(1);					
					int quantiteCommande = result.getInt(2);				
//					LigneCommande lc = new LigneCommande(idC,quantiteCommande);
//					lcs.add(lc);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lcs;
	}


}
