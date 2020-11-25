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
import org.eclipse.service.ProduitService;

@WebServlet("/panier")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String vue;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LigneCommande> lignes = new ArrayList<>();
		List<Produit> produits = new ArrayList<>();
		System.out.println("PANIER SERVLET:: GET ");		
		String action="";	
		if(request.getParameter("action")!=null) action = request.getParameter("action");   
		System.out.println("action get ===>" + action);	        
		int id = Integer.parseInt(request.getParameter("id") );			
		int quantite =  Integer.parseInt(request.getParameter("quantite"));
		Panier panier = new Panier();
		ProduitService produit = new ProduitService();	
		panier.addLigne(produit.findByIdProduct(id), quantite);
        produits = produit.produitSelectionnes();
		lignes = (List<LigneCommande>) panier.getLignes();	
		System.out.println(lignes);
		  request.setAttribute("panier",panier);
        request.setAttribute("lignes",lignes);
        request.setAttribute("produits",produits);
        vue = "/WEB-INF/panier/panier.jsp";
		//request.setAttribute("action", action);
		getServletContext().getRequestDispatcher(vue).forward(request, response); 
//		  List<LigneCommande> lignes = new ArrayList<>();
//		switch (action) {
//		case "addArticle":			
//			int idArt = Integer.parseInt(request.getParameter("id") );			
//			int quantiteCom =  Integer.parseInt(request.getParameter("qte"));
//			ProduitService ps = new ProduitService();
//			Produit produit = ps.findByIdProduct(idArt);
//			panier = new Panier();
//			panier.addLigne(produit, quantiteCom);
//			lignes = (List<LigneCommande>) panier.getLignes();		
//			request.setAttribute("lignes",lignes);	
//			vue = "/WEB-INF/panier/panier.jsp";	
//			break;
////		case "viewArticle":
////			vue = "/WEB-INF/panier/article.jsp";
////			break;
////		case "removeArticle":   
////		
////			int id = Integer.parseInt(request.getParameter("id") );
////			panier.deleteLigne(id);
////			lignes = (List<LigneCommande>) panier.getLignes();
////			request.setAttribute("lignes", lignes);
////			vue = "/WEB-INF/panier/panier.jsp";
////			break;
////		case "modifyArticle":   
////		
////			int idArt1 = Integer.parseInt(request.getParameter("id") );
////			panier.deleteLigne(idArt1);
////			lignes = (List<LigneCommande>) panier.getLignes();
////			request.setAttribute("lignes", lignes);
////			vue = "/WEB-INF/panier/panier.jsp";
////			break;
//		default:	
//			lignes = (List<LigneCommande>) panier.getLignes();	
//			panier.getSize();
//			System.out.println(panier.getSize());
//			request.setAttribute("panier",panier);			
//			request.setAttribute("lignes", lignes);
//			vue = "/WEB-INF/panier/panier.jsp";
//		}
//		request.setAttribute("action", action);
//		getServletContext().getRequestDispatcher(vue).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = request.getParameter("myPostVar");
		System.out.println("result = "+ result);
		String action="";
		if(request.getParameter("action")!=null) action = request.getParameter("action");  
        System.out.println("action post===>" + action);
        
        Panier panier = new Panier();
        List<Produit> lignes; 
        int id =  Integer.parseInt("id");	
        int quantite =  Integer.parseInt("quantite");	
    	ProduitService produit = new ProduitService();	
        panier.addLigne(produit.findByIdProduct(id), quantite);
        lignes = produit.produitSelectionnes();
        request.setAttribute("lignes",lignes);
        vue = "/WEB-INF/panier/panier.jsp";
        this.getServletContext().getRequestDispatcher(vue).forward(request, response);
         
//		switch (action) {
//		case "addArticle":				
//			Produit produit = new Produit();			
//			produit.setDesignation(request.getParameter("designation"));
//			produit.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));
//			int quantiteCom =  Integer.parseInt("quantiteCom");			
//			produit.setQuantiteStock(Integer.parseInt(request.getParameter("quantiteCom")));			
//			panier.addLigne(produit, quantiteCom);				
//			lignes = (List<LigneCommande>) panier.getLignes();
//			request.setAttribute("lignes",lignes);
//			vue = "/WEB-INF/panier/listeArticles.jsp";			
//			break;
//		case "removeArticle":   
//			System.out.println("je suis sur post pour remover");
//			int id = Integer.parseInt(request.getParameter("id") );
//			panier.deleteLigne(id);
//			lignes = (List<LigneCommande>) panier.getLignes();
//			request.setAttribute("lignes", lignes);
//			vue = "/WEB-INF/panier/listeArticles.jsp";
//			break;
//		case "modifyArticle":
//			Produit prod = new Produit();			
//			prod.setDesignation(request.getParameter("designation"));
//			prod.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));
//			int quantiteCommande = Integer.parseInt(request.getParameter("quantite"));
//			int quantiteStock = prod.getQuantiteStock()- quantiteCommande;
//			prod.setQuantiteStock(quantiteStock);
//			prod.setUrlImage((request.getParameter("urlImage")));			
//			ligne.setQuantiteCommande((quantiteCommande));
//			panier.addLigne(prod, ligne.getQuantiteCommande());
//			lignes = (List<LigneCommande>) panier.getLignes();
//			request.setAttribute("lignes", lignes);
//			vue = "/WEB-INF/panier/listeArticles.jsp";		
// 			break; 		
//		default:
//			vue = "/WEB-INF/panier/listeArticles.jsp";
//		}
//		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
//		

	}



}
