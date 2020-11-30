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


@WebServlet("/vendeur")
public class VendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Produit> produits = new ArrayList<>();
	private List<Categorie> categories = new ArrayList<>();
	private ProduitService produitService = new ProduitService();
	private CategorieService cs = new CategorieService();
	String vue;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		String url = request.getServletPath();
//		String action = url.substring(1);
//		System.out.println(url+"****");
//		String operation = "";	
//		System.out.println(" url" +url);
//		if(request.getParameter("action")!=null) action = request.getParameter("action");   
//		System.out.println("VENDEUR SERVLET GET :: action get ===>" + action);

//		request.setAttribute("action", action);
//		request.setAttribute("operation", operation);
		produits = produitService.findAll();
		request.setAttribute("produits",produits);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vendeur/vendeur.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String url = request.getServletPath();	
	String action=null;
	if(request.getParameter("action")!=null) action = request.getParameter("action");  
	System.out.println("VENDEUR SERVLET POST :: action POST ===>" + action);	
	response.sendRedirect("produit");
//	switch (action) {  
	
//	 case "/add": 	
//		 	System.out.println("je suis sur ajouter POST");
//			String designation = request.getParameter("designation");
//			Float prixUnitaire = Float.parseFloat(request.getParameter("prixUnitaire"));
//			System.out.println("DESIGNATION "  + designation + "PRIXUNITAIRE : "+prixUnitaire);						
//			int quantiteStock= Integer.parseInt(request.getParameter("quantiteStock"));
//			String urlImage = request.getParameter("urlImage");
//			byte selectionne = Byte.parseByte(request.getParameter("selectionne"));
//			Produit produit = new Produit(designation,prixUnitaire,quantiteStock,urlImage,selectionne);
//			request.setAttribute("produit", produit);
//			produitService.save(produit);		      
//			//produits = produitService.findAll();
//			//request.setAttribute("produits",produits);
//			
//			//vue = "/WEB-INF/produit/listProduit.jsp";	
//			//doGet(request, response);
//			break;
	
	  // response.sendRedirect("produit");
// this.getServletContext().getRequestDispatcher(vue).forward(request, response);


}

	
//	private static final long serialVersionUID = 1L;
//	private ProduitService produitService = new ProduitService();
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		System.out.println("VENDEUR SERVLET:: GET ");
//		request.setAttribute("produits", produitService.findAll());
//		getServletContext().getRequestDispatcher("/WEB-INF/vendeur/vendeur.jsp").forward(request, response);
//	}
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//		doGet(request, response);
//	}

}
