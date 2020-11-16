package org.eclipse.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.model.Produit;
import org.eclipse.service.ProduitService;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
    private List<Produit> list = new ArrayList<>();
    ProduitService ps = new ProduitService(); 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HomeController :: GET");         
        request.setAttribute("produits", ps.getAllProducts());
    	getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HomeController :: POST");            
        request.setAttribute("produits", ps.getAllProducts()); 
        request.getRequestDispatcher("/WEB-INF/produit/produit.jsp").forward(request, response);            
        
    }
}
