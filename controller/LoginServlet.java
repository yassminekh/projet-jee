package controller;

import dao.AuthentificationDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Si l'utilisateur accède à la page de login via GET, redirigez-le vers la page de login
       
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        try {
            boolean isAuthenticated = AuthentificationDAO.authenticate(username, password, role);

            if (isAuthenticated) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("role", role);

                // Redirection vers la page appropriée en fonction du rôle
                if ("enseignant".equals(role)) {
                    response.sendRedirect("enseignant.jsp");
                } else if ("admin".equals(role)) {
                    response.sendRedirect("administrateur.jsp");
                } else if ("agent".equals(role)) {
                    response.sendRedirect("agentTirage.jsp");
                }
            } else {
                // L'authentification a échoué, rediriger vers la page de connexion avec un message d'erreur
                request.setAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect. Veuillez réessayer.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur d'authentification
            response.sendRedirect("error.jsp");
        }
    }

}