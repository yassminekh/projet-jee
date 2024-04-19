package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Code pour vérifier les informations d'identification dans la base de données
        
        // Redirection en fonction du rôle de l'utilisateur (enseignant, agent de tirage, administrateur)
     // Redirection en fonction du rôle de l'utilisateur (enseignant, agent de tirage, administrateur)
        if (isEnseignant(username, password)) {
            response.sendRedirect("enseignant.jsp");
        } else if (isAgentTirage(username, password)) {
            response.sendRedirect("agentTirage.jsp");
        } else if (isAdmin(username, password)) {
            response.sendRedirect("administrateur.jsp");
        } else {
            // Redirection vers une page d'erreur si l'utilisateur n'a pas de rôle valide
            response.sendRedirect("error.jsp");
        }

    }
}
