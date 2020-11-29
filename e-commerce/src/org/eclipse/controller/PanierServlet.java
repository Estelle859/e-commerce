package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.LigneCommande;
import org.eclipse.model.Panier;

import org.eclipse.model.Produit;
import org.eclipse.service.LigneCommandeService;
import org.eclipse.service.PanierService;
import org.eclipse.service.ProduitService;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PanierService panierService = new PanierService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PANIER SERVLET:: GET ");
		
		request.setAttribute("panier", panierService.getLignes());
		getServletContext().getRequestDispatcher("/WEB-INF/panier/panier.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PANIER SERVLET:: POST ");
        int id =  Integer.parseInt(request.getParameter("id"));	
        int quantite =  Integer.parseInt(request.getParameter("quantite"));	
        System.out.println("id article : "+ id);
        System.out.println("quantite article : "+ quantite);
        ProduitService produit = new ProduitService();     
        panierService.addLigne(produit.findByIdProduct(id), quantite);
		doGet(request, response);      
         
	}



}
