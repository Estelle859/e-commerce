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

    ProduitService ps = new ProduitService(); 
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HomeController :: GET");         
        request.setAttribute("produits", ps.findAll());
    	getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HomeController :: POST");
        int id = Integer.parseInt(request.getParameter("id"));
        Produit article = ps.findByIdProduct(id);
        request.setAttribute("article", article); 
        getServletContext().getRequestDispatcher("/WEB-INF/panier/article.jsp").forward(request, response);    
       // request.getRequestDispatcher("/WEB-INF/produit/produit.jsp").forward(request, response);            
        
    } 
}
 