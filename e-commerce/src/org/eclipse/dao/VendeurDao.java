package org.eclipse.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.config.MyConnection;

import org.eclipse.model.Vendeur;

public class VendeurDao implements Dao<Vendeur> {

	public Vendeur save(Vendeur vendeur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT into vendeur (nom,prenom,email,telephone) values (?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, vendeur.getNom());
				ps.setString(2, vendeur.getPrenom());
				ps.setString(3,vendeur.getEmail());				
				ps.setString(4,vendeur.getTelephone());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					vendeur.setId(resultat.getInt(1));
					return vendeur;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

	public void remove(Vendeur vendeur) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM  vendeur  WHERE id = ? ; ");
				ps.setInt(1, vendeur.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Vendeur update(Vendeur vendeur) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try { 
				PreparedStatement ps = c.prepareStatement("UPDATE  vendeur SET nom=? , prenom=? , email=?, telephone=?  WHERE id=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, vendeur.getNom());
				ps.setString(2, vendeur.getPrenom());
				ps.setString(3,vendeur.getEmail());				
				ps.setString(4, vendeur.getTelephone());				
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return vendeur;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

	@Override
	public Vendeur findById(int idv) {		
			Connection c = MyConnection.getConnection();
			if (c != null) {
				try {
					PreparedStatement ps = c.prepareStatement("SELECT * FROM vendeur WHERE id = ?;");
					ps.setInt(1, idv);
					ResultSet result = ps.executeQuery();
					if (result.next()) {
						int id = result.getInt(1);
						String nom = result.getString(2);
						String prenom = result.getString(3);
						String email = result.getString(4);						
						String telephone = result.getString(5);					
						//	Vendeur vendeur = new Vendeur ( id, nom, prenom, email, telephone);
						//	return vendeur;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;

	}

	@Override
	public List<Vendeur> findAll() {
		ArrayList<Vendeur> vendeurs = new ArrayList<Vendeur>();
		Connection c = MyConnection.getConnection();
		System.out.println("connection ::" + c);
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM vendeur;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					String email = result.getString(4);						
					String telephone = result.getString(5);		
				//	Vendeur Vendeur = new Vendeur ( id, nom,prenom,email,telephone);
				//  vendeurs.add(vendeur);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vendeurs;

	}
	public ArrayList< Vendeur> findByNomAndPrenom(String nom, String prenom) {
		ArrayList< Vendeur>  vendeurs = new ArrayList<Vendeur>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Vendeur WHERE nom = ? AND prenom = ?;");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int num = result.getInt(1);
					String n = result.getString(2);
					String p = result.getString(3);
					Vendeur vendeur = new Vendeur(n, p);
					vendeurs.add(vendeur);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return vendeurs;
	}


}
