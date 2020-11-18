package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Produit;
import org.eclipse.service.ProduitService;


@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProduitService ps = new ProduitService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Produit article = ps.findByIdProduct(id);
		request.setAttribute("article", article);
		getServletContext().getRequestDispatcher("/WEB-INF/panier/article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/panier/panier.jsp").forward(request, response);
	}

}
