package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Administrateur;
import model.AgentTirage;
import model.Enseignant;

import java.io.IOException;

import dao.AdminDAO;
import dao.AgentTirageDAO;
import dao.EnseignantDAO;

/**
 * Servlet implementation class Registrer
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Afficher la page de registration
	    request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String email = request.getParameter("email");
	        String role = request.getParameter("role");
	        request.getSession().setAttribute("registeredUsername", username);
	        request.getSession().setAttribute("registeredMdp", password);
	        request.getSession().setAttribute("registeredRole", role);
	        // Ins�rer les informations dans la table appropri�e en fonction du r�le
	        if ("admin".equals(role)) {
	            AdminDAO.save(new Administrateur(username, email, password));
	        } else if ("enseignant".equals(role)) {
	            EnseignantDAO.save(new Enseignant(username, email, password));
	        } else if ("agent_tirage".equals(role)) {
	            AgentTirageDAO.save(new AgentTirage(username, email, password));
	        }

	        // Rediriger vers la page de connexion
	        response.sendRedirect("login.jsp");
		
	}

}