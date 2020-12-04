package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.LigneCommande;
import org.eclipse.model.LignePanier;
import org.eclipse.model.Panier;
import org.eclipse.model.Produit;
import org.eclipse.service.LignePanierService;
import org.eclipse.service.PanierService;
import org.eclipse.service.ProduitService;


@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitService produitService= new ProduitService();
	LignePanierService panier= new LignePanierService();
	List<LignePanier> lignes = new ArrayList<>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ARTICLE SERVLET:: GET ");
		int id = Integer.parseInt(request.getParameter("id"));
		Produit article = produitService.findByIdProduct(id);
		request.setAttribute("article", article);
		getServletContext().getRequestDispatcher("/WEB-INF/panier/article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ARTICLE SERVLET:: POST ");
			int id =  Integer.parseInt(request.getParameter("id"));	
	        int quantite =  Integer.parseInt(request.getParameter("quantite"));	
	        System.out.println("id article : "+ id);
//	        System.out.println("quantite article : "+ quantite);
	        ProduitService produit = new ProduitService();     
	        LignePanier ligne = new LignePanier(quantite,produit.findByIdProduct(id));			
		    panier.save(ligne );		    
			lignes = panier.findAll();				
			System.out.println("LIGNES IN CART"+lignes);
//	    	//Float total = panier.getTotal();
//	    	//int size = panier.getSize();
//			//	request.setAttribute("total",total);	
//			//	request.setAttribute("size",size);	
			request.setAttribute("id",id);	
			request.setAttribute("articles",lignes);				
			getServletContext().getRequestDispatcher("/WEB-INF/panier/panier.jsp").forward(request, response);
	}

}