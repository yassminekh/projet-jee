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
        // Si l'utilisateur acc�de � la page de login via GET, redirigez-le vers la page de login
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role"); // R�cup�rer le r�le � partir des param�tres de la requ�te

        try {
            boolean isAuthenticated = AuthentificationDAO.authenticate(username, password, role);

            if (isAuthenticated) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                session.setAttribute("role", role);

                // Rediriger vers le tableau de bord appropri� en fonction du r�le
                if ("enseignant".equals(role)) {
                    response.sendRedirect("enseignant.jsp");
                } else if ("admin".equals(role)) {
                    response.sendRedirect("admininstrateur.jsp");
                } else if ("agent".equals(role)) {
                    response.sendRedirect("agentTirage.jsp");
                } else {
                    // Si le r�le n'est pas valide, rediriger vers la page de connexion
                    response.sendRedirect("login.jsp");
                }
            } else {
                // L'authentification a �chou�, rediriger vers la page de connexion
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // G�rer l'erreur d'authentification
            response.sendRedirect("error.jsp");
        }
    }
}
