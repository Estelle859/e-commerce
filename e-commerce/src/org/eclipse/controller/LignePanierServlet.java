package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.LignePanier;
import org.eclipse.service.LignePanierService;
import org.eclipse.service.PanierService;
import org.eclipse.service.ProduitService;


@WebServlet("/lignepanier")
public class LignePanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<LignePanier> lignes = new ArrayList<>();
	
	private LignePanierService lp = new LignePanierService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LignePanierController :: GET");
		String url = request.getServletPath();
		String action = url.substring(1);
		System.out.println(url);
		String operation = "";
		switch (url) {
		case "/add":
			operation = "Ajouter";
			break;
		case "/update":
			operation = "Modifier";
			break;
		case "/delete":
			operation = "Supprimer";
			break;
		}
		request.setAttribute("action", action);
		request.setAttribute("operation", operation);
		request.setAttribute("ligne", lp.findAll());
		getServletContext().getRequestDispatcher("/WEB-INF/panier/lignepanier.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LignePaniernController :: POST");
		String url = request.getServletPath();
		
//		switch (url) {
//		
//        case "/add": 
//        	int id =  Integer.parseInt(request.getParameter("id"));	
//        	int quantite =  Integer.parseInt(request.getParameter("quantite"));	
//        	System.out.println("id article : "+ id);
//        	System.out.println("quantite article : "+ quantite);
//        	ProduitService produit = new ProduitService(); 
//        	
//        	panier.addLigne(produit.findByIdProduct(id), quantite);
//        	
//        	  	
//			
//			LignePanier ligne = new LignePanier(produit, quantite);
//			request.setAttribute("ligne", ligne);
//			lp.save(ligne);
//			request.setAttribute("participePasse", "ajoutée");                    
//	        break;
//        case "/update":
//        	int num = Integer.parseInt(request.getParameter("num"));
//			nom = request.getParameter("nom");
//			prenom = request.getParameter("prenom");
//			personne = new Person(num, nom, prenom);
//			request.setAttribute("personne", personne);
//			ps.update(ligne);
//			request.setAttribute("participePasse", "modifiée");
//            break;              
//        case  "/delete":           	
//    		num = Integer.parseInt(request.getParameter("num"));
//			personne = ps.findById(num);
//			request.setAttribute("personne", personne);
//			ps.remove(num);
//			request.setAttribute("participePasse", "supprimée");
//			int id = Integer.parseInt(request.getParameter("id"));
//			lp.remove(id);
//			break;       
//              
//    }
//		// redirection vers une Servlet
//		response.sendRedirect("consultLignes");	
//		//doGet(request, response);


	}
}
