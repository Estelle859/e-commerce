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


@WebServlet({"/panier","/add", "/delete","/update"})
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PanierService panierService = new PanierService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("PANIER SERVLET:: GET ");		
		String url = request.getServletPath();
		String action = url.substring(1);
		System.out.println(url+"****");
		if(request.getParameter("action")!=null)
			action = request.getParameter("action"); 		
		System.out.println("action get ===>" + action);	
		
		String vue="";		
		switch (action) {  		
		case "add":			
			System.out.println("je suis sur ajouter");	
			vue="/WEB-INF/panier/addArticle.jsp";
			break;			
		case "update":				
			int id = Integer.parseInt(request.getParameter("id"));
			Panier panier =  panierService.findByIdLigne(id);   
			request.setAttribute("panier", panier);
			vue="/WEB-INF/produit/editArticle.jsp";
			break;
			
		case "delete":
		 	System.out.println("je suis sur supprimerGET");				
			int idD = Integer.parseInt(request.getParameter("id"));
			Panier pan =  panierService.findByIdLigne(idD);  	
			vue="/WEB-INF/panier/deleteArticle.jsp";
			break;
			
		 default:          
         
        
		  request.setAttribute("lignes", panierService.getLignes());
          vue="/paniert/panier.jsp";
          break;
		}
		request.setAttribute("action", action);
		
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("PANIER SERVLET:: POST ");
//        int id =  Integer.parseInt(request.getParameter("id"));	
//        int quantite =  Integer.parseInt(request.getParameter("quantite"));	
//        System.out.println("id article : "+ id);
//        System.out.println("quantite article : "+ quantite);
//        ProduitService produit = new ProduitService();     
//        panier.addLigne(produit.findByIdProduct(id), quantite);
//		doGet(request, response); 
		
		
		
//		String url = request.getServletPath();	
//		String action=null;
//		if(request.getParameter("action")!=null) action = request.getParameter("action");  
//		System.out.println("produit servlet :: action POST ===>" + action);
//		switch (action) {  		
//		 case "add": 	
//			 	System.out.println("je suis sur ajouterx");
//				String designation = request.getParameter("designation");
//				System.out.println(request.getParameter("designation"));
//				System.out.println(request.getParameter("prixUnitaire"));
//				Float prixUnitaire = Float.parseFloat(request.getParameter("prixUnitaire"));
//				
//				int quantiteStock= Integer.parseInt(request.getParameter("quantiteStock"));
//				String urlImage = request.getParameter("urlImage");
//				byte selectionne = Byte.parseByte(request.getParameter("selectionne"));
//				Produit produit = new Produit(designation,prixUnitaire,quantiteStock,urlImage);
//				request.setAttribute("produit", produit);
//				produitService.save(produit);		      
//				produits = produitService.findAll();
//				request.setAttribute("produits",produits);
//				//doGet(request, response);
//				vue = "/WEB-INF/vendeur/vendeur.jsp";				
//				break;
//		 case "update":	
//			 System.out.println("je suis sur modifier");
//				 Produit prd = new Produit(); 
//				 prd.setId(Integer.parseInt(request.getParameter("id")));  
//				 prd.setDesignation(request.getParameter("designation"));
//				 System.out.println("nom produit " +request.getParameter("designation") + request.getParameter("id"));
//				 prd.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));
//		  //  	 prd.getCategorie().setIdCate(Integer.parseInt(request.getParameter("categorie")));
//				 prd.setQuantiteStock(Integer.parseInt(request.getParameter("quantite")));
//				 prd.setUrlImage((request.getParameter("urlImage")));
//				 prd.setSelectionne(Byte.parseByte(request.getParameter("selectionne")));
//	             produitService.update(prd);
//	             produits = produitService.findAll();          
//	             request.setAttribute("produits", produits);
//	            // doGet(request, response);
//	         	//vue = "/WEB-INF/produit/listProduit.jsp";
//	     		vue = "/WEB-INF/vendeur/vendeur.jsp";
//	 			break; 
//		  case  "delete":    
//			  	System.out.println("je suis sur supprimerPOST");
//			  	int id = Integer.parseInt(request.getParameter("id"));
//				System.out.println("we have to remove product id :::" + id );
//				produitService.remove(id);
//				produits = produitService.findAll();
//				request.setAttribute("produits", produits);
//				vue = "/WEB-INF/vendeur/vendeur.jsp";
//				//doGet(request, response);
//				break;
//		}
//		this.getServletContext().getRequestDispatcher(vue).forward(request, response);

		
         
	}



}
