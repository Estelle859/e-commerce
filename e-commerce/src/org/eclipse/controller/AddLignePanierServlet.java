package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.LignePanier;
import org.eclipse.service.LignePanierService;
import org.eclipse.service.ProduitService;

@WebServlet("/addLigne")
public class AddLignePanierServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private LignePanierService lignePanierService = new LignePanierService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("lignes", lignePanierService.findAll());
		getServletContext().getRequestDispatcher("/WEB-INF/panier/addArticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		ProduitService produit = new ProduitService(); 		
		LignePanier lignePanier = new LignePanier(id, quantite, produit.findByIdProduct(id));
		lignePanierService.save(lignePanier);
		doGet(request, response);
	}

}
