package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.service.ProduitService;


@WebServlet("/vendeur")
public class VendeurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitService produitService = new ProduitService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("VENDEUR SERVLET:: GET ");
		request.setAttribute("produits", produitService.findAll());
		getServletContext().getRequestDispatcher("/WEB-INF/vendeur/vendeur.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
