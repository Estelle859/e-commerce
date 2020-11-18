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

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LigneCommandeService ligneService = new LigneCommandeService();
	private List<LigneCommande> lignes = new ArrayList<>();
	private PanierService panierService = new PanierService();
	private String vue;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("PANIER SERVLET:: GET ");		
		String action="";
		String operation = "";
		if(request.getParameter("action")!=null) action = request.getParameter("action");   
		System.out.println("action get ===>" + action);
		switch (action) {
		case "add":			
			operation = "Ajouter au Panier";
			vue = "/WEB-INF/panier/panier.jsp";
			break;
		case "view":
			
			operation = "Ajouter au Panier";			
			vue = "/WEB-INF/panier/article.jsp";
			break;
		default:
			lignes =ligneService.findAll();
			request.setAttribute("lignes", lignes);
			vue = "/WEB-INF/panier/article.jsp";

		}
		request.setAttribute("action", action);
		request.setAttribute("operation", operation);		
		request.setAttribute("lignes", ligneService.findAll());
		getServletContext().getRequestDispatcher(vue).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action="";
		if(request.getParameter("action")!=null) action = request.getParameter("action");  
        System.out.println("action post===>" + action);
	
        switch (action) {
		case "add":				
			Produit produit = new Produit();			
			produit.setDesignation(request.getParameter("designation"));
			produit.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));	
			produit.setQuantite(Integer.parseInt(request.getParameter("quantite")));
			produit.setUrlImage((request.getParameter("urlImage")));			
			//add an article to panier i.e create ligne commande
			LigneCommande lc = new LigneCommande(produit,1);
			ligneService.save(lc);
			panierService.addItems(produit, 1);			
			lignes = ligneService.findAll();
			request.setAttribute("lignes",lignes);
			vue = "/WEB-INF/panier/panier.jsp";			
			break;
		case "edit":			
//			 Produit prd = new Produit(); 
//			 prd.setId(Integer.parseInt(request.getParameter("id")));  
//			 prd.setDesignation(request.getParameter("designation"));
//			 System.out.println("nom produit " +request.getParameter("designation") + request.getParameter("id"));
//			 prd.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));
//	    	 prd.getCategorie().setIdCate(Integer.parseInt(request.getParameter("categorie")));
//			 prd.setQuantite(Integer.parseInt(request.getParameter("quantite")));
//			 prd.setUrlImage((request.getParameter("urlImage")));
//             ps.updateProduct(prd);
//             produits = ps.getAllProducts();          
//             request.setAttribute("produits", produits);
//         	vue = "/WEB-INF/produit/listProduit.jsp";
 			break; 
		case "remove":   
//			System.out.println("we have to remove product id :::" +request.getParameter("id") );
//			ps.removeById(Integer.parseInt(request.getParameter("id")));
//			produits = ps.getAllProducts();
//			request.setAttribute("produits", produits);
//			vue = "/WEB-INF/produit/listProduit.jsp";
			break;
		default:
//			articles = panier.getItems();
//			request.setAttribute("articles", articles);
			vue = "/WEB-INF/panier/panier.jsp";
		}
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
		

	}



}
