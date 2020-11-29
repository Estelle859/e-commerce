package org.eclipse.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.config.MyConnection;
import org.eclipse.dao.Dao;
import org.eclipse.model.Produit;

public class ProduitDao implements Dao<Produit> {

	@Override
	public Produit save(Produit produit) {
		Connection c = MyConnection.getConnection();
		System.out.println("connection ::" + c);
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("INSERT into produit (designation,prixUnitaire,quantitéEnStock,urlImage, selectionne) values (?,?,?,?,?); ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, produit.getDesignation());
				ps.setFloat(2, produit.getPrixUnitaire());
				ps.setInt(3, produit.getQuantiteStock());
				ps.setString(4, produit.getUrlImage());
				ps.setInt(5,produit.isSelectionne()); 			
				ps.executeUpdate();
				ResultSet resultat = ps.getGeneratedKeys();
				if (resultat.next()) {
					produit.setId(resultat.getInt(1));
					return produit;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	
	}

	@Override
	public void remove(Produit produit) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("DELETE FROM  produit  WHERE id = ? ; ");
				ps.setInt(1, produit.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Produit update(Produit produit) {
		Connection c = MyConnection.getConnection();
		
		if (c != null) {
			try { 
				PreparedStatement ps = c.prepareStatement("UPDATE  produit SET designation=? , prixUnitaire=? , quantitéEnStock=?, urlImage=?, selectionne=?  WHERE id=? ; ",
						PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, produit.getDesignation());
				ps.setFloat(2, produit.getPrixUnitaire());
				ps.setInt(3, produit.getQuantiteStock());
				ps.setString(4, produit.getUrlImage());
				ps.setInt(5,produit.isSelectionne());
				int nbr = ps.executeUpdate();
				if (nbr != 0) {
					return produit;
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Produit findById(int idProduit) {
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Produit WHERE id = ?;");
				ps.setInt(1, idProduit);
				ResultSet result = ps.executeQuery();
				if (result.next()) {
					int id = result.getInt(1);
					String designation = result.getString(2);
					Float prixUnitaire = result.getFloat(3);
					int quantite = result.getInt(4);
					String urlImage = result.getString(5);
					int selectionne = result.getInt(6);
					Produit produit = new Produit ( id,  designation,  prixUnitaire, quantite,  urlImage, selectionne);
					return produit;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Produit> findAll() {
		ArrayList<Produit> produits = new ArrayList<Produit>();
		Connection c = MyConnection.getConnection();
		System.out.println("connection ::" + c);
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Produit;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String designation = result.getString(2);
					Float prixUnitaire = result.getFloat(3);
					int quantite = result.getInt(4);
					String urlImage = result.getString(5);
					int selectionne = result.getInt(6);
					Produit produit = new Produit ( id,  designation,  prixUnitaire, quantite,  urlImage, selectionne);
					produits.add(produit);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return produits;
	}	
	public List<Produit> produitSelectionnes() {
		ArrayList<Produit> selectionnes = new ArrayList<Produit>();
		Connection c = MyConnection.getConnection();
		if (c != null) {
			try {
				PreparedStatement ps = c.prepareStatement("SELECT * FROM Produit WHERE selectionne=1;");
				ResultSet result = ps.executeQuery();
				while (result.next()) {
					int id = result.getInt(1);
					String designation = result.getString(2);
					Float prixUnitaire = result.getFloat(3);
					int quantite = result.getInt(4);
					String urlImage = result.getString(5);
					int selectionne = result.getInt(6);
					Produit produit = new Produit ( id,  designation,  prixUnitaire, quantite,  urlImage, selectionne);
					selectionnes.add(produit);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return selectionnes;
		
	}


}
