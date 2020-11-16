package org.eclipse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.model.*;
import org.eclipse.service.UtilisateurService;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UtilisateurService utilisateurService = new UtilisateurService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/connexion/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		Utilisateur utilisateur = utilisateurService.findByNomAndPrenom(nom, prenom);
		if (utilisateur == null) {
			response.sendRedirect("connexion");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("utilisateur", utilisateur);
			if (utilisateur.getType().equals("client")) {
				response.sendRedirect("client");
				
			} else {
				response.sendRedirect("vendeur");

			}
		}
	}
}
/*************************/


