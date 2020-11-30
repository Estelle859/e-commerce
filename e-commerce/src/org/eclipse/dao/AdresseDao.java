package org.eclipse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.config.MyConnection;
import org.eclipse.model.Adresse;
import org.eclipse.model.Utilisateur;

public class AdresseDao implements Dao<Adresse> {
	private UtilisateurDao utilisateurDao = new  UtilisateurDao();
	@Override
	public Adresse save(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement(
						"insert into adresse (rue,ville,codePostal) values (?,?, ?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, adresse.getRue());
				ps.setString(2, adresse.getVille());
				ps.setString(3, adresse.getCodePostal());
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					adresse.setId(resultat.getInt(1));
					for ( Utilisateur user : adresse.getUtilisateur()) {
						if (user.getId() == 0) {
							user = utilisateurDao.save(user);
						}
						ps = c.prepareStatement("INSERT INTO utilisateur_adresse (utilisateur,adresse) values (?,?); ",
								PreparedStatement.RETURN_GENERATED_KEYS);
						ps.setInt(1, user.getId());
						ps.setInt(2, adresse.getId());
						ps.executeUpdate();
					}
					return adresse;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public void remove(Adresse adresse) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM utilisateur_adresse  WHERE adresse = ? ; ");
				ps.setInt(1, adresse.getId());
				ps.executeUpdate();
				 ps = c.prepareStatement("DELETE FROM  adresse  WHERE idAdresse = ? ; ");
				ps.setInt(1, adresse.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public Adresse update(Adresse t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Adresse findById(int id) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Adresse WHERE idAdresse = ?;");
				ps.setInt(1, id);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int idAdresse = result.getInt(1);
					String rue = result.getString(2);
					String codePostal = result.getString(3);
					String ville = result.getString(4);
					ps = c.prepareStatement("SELECT * FROM utilisateur_adresse WHERE adresse = ?;");
					ps.setInt(1, id);
					ResultSet result2 = ps.executeQuery();
					List<Utilisateur> users = new ArrayList<>();
					while (result2.next()) {
						int num = result2.getInt(2);
						Utilisateur user =utilisateurDao.findById(num);
						users.add(user);
					}
					Adresse adresse = new Adresse(idAdresse, rue, codePostal, ville, users);
					return adresse;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Adresse> findAll() {
		UtilisateurDao	utilisateurDao = new UtilisateurDao();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Adresse;");
				List<Adresse> adresses = new ArrayList<>();
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int idAdresse = result.getInt(1);
					String rue = result.getString(2);
					String codePostal = result.getString(3);
					String ville = result.getString(4);
//					ps = c.prepareStatement("SELECT * FROM personne_adresse WHERE idAdresse = ?;");
//					ps.setInt(1, idAdresse);
//					ResultSet result2 = ps.executeQuery();
//					ArrayList<Personne> personnes = new ArrayList<Personne>();
//					while (result2.next()) {
//						int num = result2.getInt(2);
//						Personne personne = personneDao.findById(num);
//						personnes.add(personne);
//					}
					Adresse adresse = findById(idAdresse);
					 adresses.add(adresse);
				}
				return adresses;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
