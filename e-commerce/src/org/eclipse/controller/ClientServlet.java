package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Panier;
import org.eclipse.model.Produit;
import org.eclipse.service.PanierService;
import org.eclipse.service.ProduitService;

@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    PanierService panier = new PanierService(); 
	ProduitService produitservice = new ProduitService();
	private static final long serialVersionUID = 1L;
	private ProduitService produitService = new ProduitService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CLIENT SERVLET:: GET ");
		int size = panier.getSize();
		request.setAttribute("size",size);
		request.setAttribute("produits", produitService.findAll());
		getServletContext().getRequestDispatcher("/WEB-INF/client/client.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ClientController :: POST");		
		int id = Integer.parseInt(request.getParameter("id"));
		Produit article = produitservice.findByIdProduct(id);		
		request.setAttribute("article",article);
		request.setAttribute("id", id);
        getServletContext().getRequestDispatcher("/WEB-INF/panier/article.jsp").forward(request, response);    
		
	}

}
