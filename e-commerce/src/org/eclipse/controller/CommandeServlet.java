package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Commande;
import org.eclipse.model.LigneCommande;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Produit;
import org.eclipse.service.LigneCommandeService;
import org.eclipse.service.LignePanierService;
import org.eclipse.service.ProduitService;

@WebServlet("/commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProduitService produitService = new ProduitService();  
	LignePanierService lps = new LignePanierService();
	LigneCommandeService lcs = new LigneCommandeService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("panier", lps.findAll());		
		getServletContext().getRequestDispatcher("/WEB-INF/panier/commande.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int ligneid =  Integer.parseInt(request.getParameter("id"));	
        int quantite =  Integer.parseInt(request.getParameter("quantite"));
        float prix = Float.parseFloat(request.getParameter("prix"));     
        Produit produit =  produitService.findByIdProduct(ligneid);
		LigneCommande lc = new LigneCommande(quantite, produit, prix);
		//adding in into ligne commande
		lcs.save(lc);
		//supprimer de ligne panier
		lps.remove(ligneid);
		getServletContext().getRequestDispatcher("/WEB-INF/panier/valide.jsp").forward(request, response);
	}

}
