package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.config.MyConnection;
import org.eclipse.model.Client;


public class ClientDao implements Dao<Client> {

	public Client save(Client client) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT into client (nom,prenom,email,telephone) values (?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, client.getNom());
				ps.setString(2, client.getPrenom());
				ps.setString(3,client.getEmail());				
				ps.setString(4,client.getTelephone());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					client.setId(resultat.getInt(1));
					return client;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

	public void remove(Client client) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM  client  WHERE id = ? ; ");
				ps.setInt(1, client.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public Client update(Client client) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try { 
				PreparedStatement ps = c.prepareStatement("UPDATE  client SET nom=? , prenom=? , email=?, telephone=?  WHERE id=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, client.getNom());
				ps.setString(2, client.getPrenom());
				ps.setString(3,client.getEmail());				
				ps.setString(4, client.getTelephone());				
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return client;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

	@Override
	public Client findById(int idCli) {		
			Connection c = MyConnection.getConnection();
			if (c != null) {
				try {
					PreparedStatement ps = c.prepareStatement("SELECT * FROM client WHERE id = ?;");
					ps.setInt(1, idCli);
					ResultSet result = ps.executeQuery();
					if (result.next()) {
						int id = result.getInt(1);
						String nom = result.getString(2);
						String prenom = result.getString(3);
						String email = result.getString(4);						
						String telephone = result.getString(5);					
						Client client = new Client ( id, nom, prenom, email,  telephone);
						return client;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return null;

	}

	@Override
	public List<Client> findAll() {
		ArrayList<Client> clients = new ArrayList<Client>();
		Connection c = MyConnection.getConnection();
		System.out.println("connection ::" + c);
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Client;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String nom = result.getString(2);
					String prenom = result.getString(3);
					String email = result.getString(4);						
					String telephone = result.getString(5);		
					Client client = new Client ( id, nom,prenom,email,telephone);
					clients.add(client);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clients;

	}
	public ArrayList<Client> findByNomAndPrenom(String nom, String prenom) {
		ArrayList<Client> clients = new ArrayList<Client>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Client WHERE nom = ? AND prenom = ?;");
				ps.setString(1, nom);
				ps.setString(2, prenom);
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int num = result.getInt(1);
					String n = result.getString(2);
					String p = result.getString(3);
					Client client = new Client(n, p);
					clients.add(client);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return clients;
	}

}
