package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Produit;
import org.eclipse.service.ProduitService;

@WebServlet({ "/listProduit","/addProduit", "/removeProduit", "/editProduit" })
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Produit> produits = new ArrayList<>();
	private ProduitService ps = new ProduitService();
	String vue;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		String action = url.substring(1);		
		System.out.println(url);
		String operation = "";
		switch (url) {
		case "/addProduit":
			operation = "Ajouter";
			vue =  "/WEB-INF/produit/addProduit.jsp";
			break;
		case "/editProduit":
			operation = "Modifier";
			vue =  "/WEB-INF/produit/editProduit.jsp";
			break;
		case "/removeProduit":
			operation = "Supprimer";
			vue =  "/WEB-INF/produit/deleteProduit.jsp";
			break;
        default:                              
            produits = ps.getAllProducts();           
            request.setAttribute("produits", produits);
            vue="/WEB-INF/produit/listProduit.jsp";
             
		}
		request.setAttribute("action", action);
		request.setAttribute("operation", operation);
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		switch (url) {
		case "/addProduit":
			String designation = request.getParameter("designation");
			Float prix  = Float.parseFloat(request.getParameter("prix"));
			String categorie = request.getParameter("categorie");
			Produit produit = new Produit(0, designation,prix,0, categorie, false, designation);
			request.setAttribute("produit", produit);
			ps.saveProduct(produit);
			vue="/WEB-INF/produit/listProduit.jsp";
			break;
		case "/editProduit":
			int id = Integer.parseInt(request.getParameter("id"));		
			String design = request.getParameter("designation");
			Float prixU = Float.parseFloat(request.getParameter("prix"));
			String cate = request.getParameter("categorie");
			produit = new Produit(id,design,prixU,0, cate, false, design);
			request.setAttribute("produit", produit);
			ps.updateProduct(produit);	
			vue="/WEB-INF/produit/listProduit.jsp";
			break;
		case "/removeProduit":
			id = Integer.parseInt(request.getParameter("id"));
			produit = ps.findByIdProduct(id);
			request.setAttribute("produit", produit);
			ps.removeById(id);		
			vue="/WEB-INF/produit/listProduit.jsp";
			break;
		default:                              
            produits = ps.getAllProducts();           
            request.setAttribute("produits", produits);
            vue="/WEB-INF/produit/listProduit.jsp";
		}
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);
	
	}

}






