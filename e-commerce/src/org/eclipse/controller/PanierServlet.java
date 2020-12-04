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
import org.eclipse.service.LigneCommandeService;
import org.eclipse.service.LignePanierService;
import org.eclipse.service.PanierService;
import org.eclipse.service.ProduitService;


@WebServlet({"/panier","/addPanier", "/deletePanier","/updatePanier","/consultePanier"})
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PanierService panierService = new PanierService();
	ProduitService produitService= new ProduitService();
	private LignePanierService lignePanierService = new LignePanierService();
	private List<LignePanier> lignes = new ArrayList<>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("PANIER SERVLET:: GET ");		
		String url = request.getServletPath();
		String action = url.substring(1);
		System.out.println(url);
		if(request.getParameter("action")!=null)
			action = request.getParameter("action"); 		
		System.out.println("action get ===>" + action);	
		
		String vue="";		
		switch (url) {  		
		case "/addPanier":			
			System.out.println("je suis sur ajouter");	
			int id =  Integer.parseInt(request.getParameter("id"));	
	        int quantite =  Integer.parseInt(request.getParameter("quantite"));	
	        System.out.println("id article : "+ id);
	        System.out.println("quantite article : "+ quantite);
	        ProduitService produit = new ProduitService();     
	        LignePanier ligne = new LignePanier(quantite,produit.findByIdProduct(id));
			System.out.println("QUANTITY SELECTED " + ligne.getQuantiteSelectionne());	        
			lignePanierService.save(ligne );		      
			lignes = lignePanierService.findAll();	
			System.out.println("LIGNES IN PANIER" + lignes); 			
			request.setAttribute("articles",lignes);	
			vue="/WEB-INF/panier/panier.jsp";
			break;			
		case "/updatePanier":				
			int idU = Integer.parseInt(request.getParameter("id"));
			System.out.println("ID ARTICLE" + idU);
			LignePanier lignepanier =  lignePanierService.findById(idU); 
			System.out.println("LIGNES IN PANIER to update" + lignepanier);
			request.setAttribute("ligne", lignepanier);
			vue="/WEB-INF/panier/editArticle.jsp";
			break;
			
		case "/deletePanier":
		 	System.out.println("je suis sur supprimerGET");				
			int idD = Integer.parseInt(request.getParameter("id"));
			System.out.println("id ligne " + idD);
			LignePanier pan =  lignePanierService.findById(idD);			
			lignePanierService.remove(idD);		
			request.setAttribute("articles",lignePanierService.findAll());
			vue="/WEB-INF/panier/panier.jsp";
			break;
		case "/consultePanier":
		 	System.out.println("je suis sur consulteGET");				
			request.setAttribute("articles",produitService.findAll());
			vue="/WEB-INF/client/client.jsp";
			break;
		default :
		request.setAttribute("lignes",lignePanierService.findAll());
		vue="/WEB-INF/panier/panier.jsp";
		
		}
//		request.setAttribute("action", action);
//		Float total = lignePanierService.getTotal();
//    	int size = lignePanierService.getSize();
//		request.setAttribute("total",total);	
//		request.setAttribute("size",size);
	
	//	request.setAttribute("lignes", lignePanierService.findAll());
		this.getServletContext().getRequestDispatcher(vue).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PANIER SERVLET:: POST ");
		//updating quantite de ligne panier selectionn
		String action ="";
		if(request.getParameter("action")!=null)
			action = request.getParameter("action");
		
		System.out.println("action post panier ===>" + action);		
		//int id =  Integer.parseInt(request.getParameter("id"));	
		int quantite =  Integer.parseInt(request.getParameter("quantiteSelection"));
		System.out.println("PANIER SERVLET:: POST ");
      //  System.out.println("id article : "+ id);
        System.out.println("quantite article : "+ quantite);
        ProduitService produit = new ProduitService(); 
     //   LignePanier ligne = new LignePanier(quantite , produit.findByIdProduct(id));        
      //  lignePanierService.update(ligne);  
        request.setAttribute("articles", lignePanierService.findAll());
        doGet(request, response); 
   
        	
	}



}
