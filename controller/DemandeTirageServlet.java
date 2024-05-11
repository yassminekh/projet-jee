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
            // R�cup�rer la liste des t�ches de l'agent de tirage depuis la base de donn�es
            List<Tache> taches = TachesDAO.getTaches();

            // Ajouter la liste des t�ches � l'objet request comme attribut
            request.setAttribute("taches", taches);

            // Rediriger vers la page JSP qui affiche les t�ches
            request.getRequestDispatcher("egentTirage.jsp").forward(request, response);
        } catch (SQLException e) {
            // G�rer les erreurs de base de donn�es
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
            int nombreEtudiantsDansGroupe = 30; // Supposons que le nombre d'�tudiants dans le groupe soit 30, vous pouvez le r�cup�rer depuis la base de donn�es

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

                // Ajoutez la demande � la requ�te et redirigez vers la page de confirmation
                request.setAttribute("demande", demande);
                request.getRequestDispatcher("confirmation.jsp").forward(request, response);
            } else {
                // Le nombre de copies demand�es est invalide
                request.setAttribute("erreur", "Le nombre de copies demand�es est invalide.");
                // Rediriger vers la page de formulaire pour une nouvelle saisie
                request.getRequestDispatcher("enseignant.jsp").forward(request, response);
            }
        } else {
            // Rediriger vers la page de formulaire pour une nouvelle saisie si le champ nombreCopies est vide
            request.getRequestDispatcher("enseignant.jsp").forward(request, response);
        }
    }
}
