package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.DemandeTirage;
import model.Tache;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import dao.TachesDAO;

/**
 * Servlet implementation class DemandeTirageServlet
 */

public class DemandeTirageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeTirageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Récupérer la liste des tâches de l'agent de tirage depuis la base de données
            List<Tache> taches = TachesDAO.getTaches();

            // Ajouter la liste des tâches à l'objet request comme attribut
            request.setAttribute("taches", taches);

            // Rediriger vers la page JSP qui affiche les tâches
            request.getRequestDispatcher("egentTirage.jsp").forward(request, response);
        } catch (SQLException e) {
            // Gérer les erreurs de base de données
            e.printStackTrace();
            // Rediriger vers une page d'erreur
            response.sendRedirect("erreur.jsp");
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCopiesStr = request.getParameter("nombreCopies");
        if (nombreCopiesStr != null && !nombreCopiesStr.isEmpty()) {
            int nombreCopies = Integer.parseInt(nombreCopiesStr);
            int nombreEtudiantsDansGroupe = 30; // Supposons que le nombre d'étudiants dans le groupe soit 30, vous pouvez le récupérer depuis la base de données

            if (nombreCopies > 0 && nombreCopies <= nombreEtudiantsDansGroupe) {
                // Le nombre de copies est valide
                String matiere = request.getParameter("matiere");
                String groupe = request.getParameter("groupe");
                String document = request.getParameter("document");
                Part filePart = request.getPart("documentPDF");
                InputStream pdfInputStream = filePart.getInputStream();
                DemandeTirage demande = new DemandeTirage(matiere, groupe, document, null, null, nombreCopies, nombreEtudiantsDansGroupe);

                // Envoyez la demande
                demande.envoyerDemandeImpression();

                // Ajoutez la demande à la requête et redirigez vers la page de confirmation
                request.setAttribute("demande", demande);
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
            } else {
                // Le nombre de copies demandées est invalide
                request.setAttribute("erreur", "Le nombre de copies demandées est invalide.");
                // Rediriger vers la page de formulaire pour une nouvelle saisie
                request.getRequestDispatcher("enseignant.jsp").forward(request, response);
            }
        } else {
            // Rediriger vers la page de formulaire pour une nouvelle saisie si le champ nombreCopies est vide
            request.getRequestDispatcher("enseignant.jsp").forward(request, response);
        }
    }
}
