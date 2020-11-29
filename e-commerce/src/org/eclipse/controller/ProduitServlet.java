package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Categorie;
import org.eclipse.model.Produit;
import org.eclipse.service.CategorieService;
import org.eclipse.service.ProduitService;

@WebServlet({"/produit","/add", "/delete","/update"})
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Produit> produits = new ArrayList<>();
	private List<Categorie> categories = new ArrayList<>();
	private ProduitService produitService = new ProduitService();
	private CategorieService cs = new CategorieService();
	String vue;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = request.getServletPath();
		String action = url.substring(1);
		System.out.println(url);
		String operation = "";	
		if(request.getParameter("action")!=null) action = request.getParameter("action");   
		System.out.println("produit servlet :: action get ===>" + action);
		System.out.println(" url" +url);
		
		switch (action) {   
		
		case "add":
			System.out.println("je suis sur ajouter");
			operation = "Ajouter";
			// liste categories
			//	categories = cs.listCategories();
			//request.setAttribute("categories", categories);			
			break;
			
		case "update":
			operation = "Modifier";
//			System.out.println("produit id " + request.getParameter("id"));
//			int idP = Integer.parseInt(request.getParameter("id"));
//			produit = produitService.findByIdProduct(idP);
//			request.setAttribute("produit", produit);			
			break;
			
		case "delete":

			operation = "Supprimer";
//			System.out.println("produit id " + request.getParameter("id"));
//			int id = Integer.parseInt(request.getParameter("id"));
//			Produit produit =  produitService.findByIdProduct(id);               
//            request.setAttribute("produit",produit);
//            categories = cs.listCategories();
//			request.setAttribute("categories", categories);				
			break;

		default:
			//produits =produitService.findAll();
			//request.setAttribute("produits", produits);
		}
		request.setAttribute("action", action);
		request.setAttribute("operation", operation);
		this.getServletContext().getRequestDispatcher("/WEB-INF/produit/listProduit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();	
		String action=null;
		if(request.getParameter("action")!=null) action = request.getParameter("action");   
		switch (action) {  
		
		 case "add": 	
			 	System.out.println("je suis sur ajouter");
				String designation = request.getParameter("designation");
				Float prixUnitaire = Float.parseFloat(request.getParameter("prixUnitaire"));
				int quantiteStock= Integer.parseInt(request.getParameter("quantiteStock"));
				String urlImage = request.getParameter("urlImage");
				int selectionne = Integer.parseInt(request.getParameter("selectionne"));
				Produit produit = new Produit(designation,prixUnitaire,quantiteStock,urlImage);
				request.setAttribute("produit", produit);
				produitService.save(produit);		      
				produits = produitService.findAll();
				request.setAttribute("produits",produits);
				doGet(request, response);
				//vue = "/WEB-INF/produit/listProduit.jsp";				
				break;
		 case "update":	
			 System.out.println("je suis sur modifier");
				 Produit prd = new Produit(); 
				 prd.setId(Integer.parseInt(request.getParameter("id")));  
				 prd.setDesignation(request.getParameter("designation"));
				 System.out.println("nom produit " +request.getParameter("designation") + request.getParameter("id"));
				 prd.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));
		  //  	 prd.getCategorie().setIdCate(Integer.parseInt(request.getParameter("categorie")));
				 prd.setQuantiteStock(Integer.parseInt(request.getParameter("quantite")));
				 prd.setUrlImage((request.getParameter("urlImage")));
				 prd.setSelectionne(Integer.parseInt(request.getParameter("selectionne")));
	             produitService.update(prd);
	             produits = produitService.findAll();          
	             request.setAttribute("produits", produits);
	             doGet(request, response);
	         	//vue = "/WEB-INF/produit/listProduit.jsp";
	 			break; 
		  case  "delete":    
			  System.out.println("je suis sur supprimer");
				System.out.println("we have to remove product id :::" +request.getParameter("id") );
				produitService.remove(Integer.parseInt(request.getParameter("id")));
				produits = produitService.findAll();
				request.setAttribute("produits", produits);
				doGet(request, response);
				//vue = "/WEB-INF/produit/listProduit.jsp";
				break;
		default:
				produits = produitService.findAll();
				request.setAttribute("produits", produits);
				vue = "/WEB-INF/produit/listProduit.jsp";
		}
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);

	}

}
