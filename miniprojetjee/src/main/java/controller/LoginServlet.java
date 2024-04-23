package controller;

import java.io.IOException;
import dao.AdminDAO;
import dao.AgentTirageDAO;
import dao.EnseignantDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
      
        // Vérifier si les champs de nom d'utilisateur et de mot de passe sont vides
        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            // Rediriger vers une page d'erreur indiquant que les champs sont vides
            response.sendRedirect("error.jsp");
            return;
        }
        
        // Vérifier si l'utilisateur est un enseignant
        if (isEnseignant(username, password)) {
            // Stocker le rôle dans la session
            HttpSession session = request.getSession();
            session.setAttribute("role", "enseignant");
            // Rediriger vers la page de l'enseignant
            response.sendRedirect("enseignant.jsp");
            return;
        }
        
        // Vérifier si l'utilisateur est un agent de tirage
        if (isAgentTirage(username, password)) {
            // Stocker le rôle dans la session
            HttpSession session = request.getSession();
            session.setAttribute("role", "agentTirage");
            // Rediriger vers la page de l'agent de tirage
            response.sendRedirect("agentTirage.jsp");
            return;
        }
        
        // Vérifier si l'utilisateur est un administrateur
        if (isAdmin(username, password)) {
            // Stocker le rôle dans la session
            HttpSession session = request.getSession();
            session.setAttribute("role", "administrateur");
            // Rediriger vers la page de l'administrateur
            response.sendRedirect("administrateur.jsp");
            return;
        }
        
        // Si l'utilisateur n'appartient à aucun des rôles définis, rediriger vers une page d'erreur
        response.sendRedirect("error.jsp");
    }

    private boolean isEnseignant(String username, String password) {
        // Utilisez la méthode de DAO pour vérifier si l'utilisateur est un enseignant
        return EnseignantDAO.getByUsernameAndPassword(username, password) != null;
    }

    private boolean isAgentTirage(String username, String password) {
        // Implémentez la logique pour vérifier si l'utilisateur est un agent de tirage
        return AgentTirageDAO.getByUsernameAndPassword(username, password) != null;
    }

    private boolean isAdmin(String username, String password) {
        // Implémentez la logique pour vérifier si l'utilisateur est un administrateur
        return AdminDAO.getByUsernameAndPassword(username, password) != null;
    }
}
