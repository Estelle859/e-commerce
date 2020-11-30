package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.config.MyConnection;
import org.eclipse.model.Utilisateur;

public class UtilisateurDao implements Dao<Utilisateur> {

	public Utilisateur save(Utilisateur user) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT into utilisateur (nom,prenom,email,password,telephone,type) values (?,?,?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getNom());
				ps.setString(2, user.getPrenom());
				ps.setString(3,user.getEmail());	
				ps.setString(4,user.getPassword());
				ps.setString(5,user.getTelephone());
				ps.setString(6,user.getType());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					user.setId(resultat.getInt(1));
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

	public void remove(Utilisateur user) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM  utilisateur  WHERE idUtilisateur = ? ; ");
				ps.setInt(1, user.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Utilisateur update(Utilisateur user) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try { 
				PreparedStatement ps = c.prepareStatement("UPDATE  utilisateur  SET nom=? , prenom=? , email=?, telephone=?,type=?  WHERE idUtilisateur=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getNom());
				ps.setString(2, user.getPrenom());
				ps.setString(3,user.getEmail());				
				ps.setString(4, user.getTelephone());	
				ps.setString(5, user.getType());
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return user;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

	@Override
	public Utilisateur findById(int idUser) {		
			Connection c = MyConnection.getConnection();
			if (c != null) {
				try {
					PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur WHERE idUtilisateur = ?;");
					ps.setInt(1, idUser);
					ResultSet result = ps.executeQuery();
					if (result.next()) {
						int id = result.getInt(1);
						String nom = result.getString(2);
						String prenom = result.getString(3);
						String email = result.getString(4);	
						String password = result.getString(5);	
						String telephone = result.getString(6);	
						String type = result.getString(7);
						Utilisateur user = new Utilisateur( id, nom,prenom,email,password,telephone,type);
						return user;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;

	}

	@Override
	public List<Utilisateur> findAll() {
		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		Connection c = MyConnection.getConnection();
		System.out.println("connection ::" + c);
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					String email = result.getString(4);	
					String password = result.getString(5);	
					String telephone = result.getString(6);	
					String type = result.getString(7);
					Utilisateur user = new Utilisateur( id, nom,prenom,email,password,telephone,type);
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;

	}
	public Utilisateur findByUserLogin(String userName, String pass) {
		System.out.println("user & pass" + userName+pass);
		ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password=?;");
				ps.setString(1, userName);
				ps.setString(2, pass);
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					String email = result.getString(4);	
					String password = result.getString(5);	
					String telephone = result.getString(6);	
					String type = result.getString(7);
					System.out.println("n & p ::: " + email + password);
					Utilisateur user = new Utilisateur(id, nom,prenom,email,password,telephone,type);
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
