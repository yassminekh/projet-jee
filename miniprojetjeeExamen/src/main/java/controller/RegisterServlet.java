package controller;

import java.io.IOException;

import dao.AdminDAO;
import dao.AgentTirageDAO;
import dao.EnseignantDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Administrateur;
import model.AgentTirage;
import model.Enseignant;



public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role");

        // Insérer les informations dans la table appropriée en fonction du rôle
        if ("admin".equals(role)) {
            AdminDAO.save(new Administrateur(username, password, email));
        } else if ("enseignant".equals(role)) {
            EnseignantDAO.save(new Enseignant(username, password, email));
        } else if ("agent_tirage".equals(role)) {
            AgentTirageDAO.save(new AgentTirage(username, password, email));
        }

        // Rediriger vers la page de connexion
        response.sendRedirect("login.jsp");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Afficher la page de registration
	    request.getRequestDispatcher("register.jsp").forward(request, response);
	}

}
