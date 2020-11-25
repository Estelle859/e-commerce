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

@WebServlet({"/produit","/add", "/remove","/update"})

public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Produit> produits = new ArrayList<>();
	private List<Categorie> categories = new ArrayList<>();
	private ProduitService ps = new ProduitService();
	private CategorieService cs = new CategorieService();
	String vue;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	//	String url = request.getServletPath();
	//	String action = url.substring(1);
	//	System.out.println(url);
		String action="";
		String operation = "";
		if(request.getParameter("action")!=null) action = request.getParameter("action");   
		System.out.println("action get ===>" + action);
		switch (action) {    
		//switch (url) {
		case "add":
			operation = "Ajouter";
			// liste categories
			categories = cs.listCategories();
			request.setAttribute("categories", categories);
			vue = "/WEB-INF/produit/addProduit.jsp";
			break;
		case "edit":
			System.out.println("produit id " + request.getParameter("id"));
			int id = Integer.parseInt(request.getParameter("id"));
			Produit produit =  ps.findByIdProduct(id);               
            request.setAttribute("produit",produit);
            categories = cs.listCategories();
			request.setAttribute("categories", categories);
			operation = "Modifier";
			vue = "/WEB-INF/produit/editProduit.jsp";
			break;
		case "remove":
			System.out.println("produit id " + request.getParameter("id"));
			int idP = Integer.parseInt(request.getParameter("id"));
			produit = ps.findByIdProduct(idP);
			request.setAttribute("produit", produit);
			operation = "Supprimer";
			vue = "/WEB-INF/produit/deleteProduit.jsp";
			break;
		default:
			produits = ps.getAllProducts();
			request.setAttribute("produits", produits);
			vue = "/WEB-INF/produit/listProduit.jsp";

		}
		request.setAttribute("action", action);
		request.setAttribute("operation", operation);
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action="";
		if(request.getParameter("action")!=null) action = request.getParameter("action");  
        System.out.println("action post===>" + action);
		//String url = request.getServletPath();
		//switch (url) {
        switch (action) {
		case "add":
			Produit produit = new Produit();
			produit.setDesignation(request.getParameter("designation"));
			produit.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));
			System.out.println("cATEGORIE " +request.getParameter("categorie"));
			produit.getCategorie().setIdCate(Integer.parseInt(request.getParameter("categorie")));
			produit.setQuantiteStock(Integer.parseInt(request.getParameter("quantiteStock")));
			produit.setUrlImage((request.getParameter("urlImage")));       
			ps.save(produit);
			produits = ps.getAllProducts();
			request.setAttribute("produits",produits);
			vue = "/WEB-INF/produit/listProduit.jsp";
			break;
		case "edit":			
			 Produit prd = new Produit(); 
			 prd.setId(Integer.parseInt(request.getParameter("id")));  
			 prd.setDesignation(request.getParameter("designation"));
			 System.out.println("nom produit " +request.getParameter("designation") + request.getParameter("id"));
			 prd.setPrixUnitaire(Float.parseFloat(request.getParameter("prixUnitaire")));
	    	 prd.getCategorie().setIdCate(Integer.parseInt(request.getParameter("categorie")));
			 prd.setQuantiteStock(Integer.parseInt(request.getParameter("quantite")));
			 prd.setUrlImage((request.getParameter("urlImage")));
             ps.update(prd);
             produits = ps.getAllProducts();          
             request.setAttribute("produits", produits);
         	vue = "/WEB-INF/produit/listProduit.jsp";
 			break; 
		case "remove":   
			System.out.println("we have to remove product id :::" +request.getParameter("id") );
			ps.removeById(Integer.parseInt(request.getParameter("id")));
			produits = ps.getAllProducts();
			request.setAttribute("produits", produits);
			vue = "/WEB-INF/produit/listProduit.jsp";
			break;
		default:
			produits = ps.getAllProducts();
			request.setAttribute("produits", produits);
			vue = "/WEB-INF/produit/listProduit.jsp";
		}
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);

	}

}
