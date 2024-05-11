package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Enseignant;

import java.io.IOException;
import java.util.List;

import dao.EnseignantDAO;

/**
 * Servlet implementation class AdminEnseignantServlet
 */
public class AdminEnseignantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminEnseignantServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String action = request.getParameter("action");
	    if (action != null) {
	        switch (action) {
	            case "create":
	                request.getRequestDispatcher("ajouterEnseignant.jsp").forward(request, response);
	                break;
	            case "editEnseignant":
	                // Récupérer l'ID de l'enseignant à modifier depuis la requête
	                String enseignantId = request.getParameter("id");
	                if (enseignantId != null && !enseignantId.isEmpty()) {
	                    // Récupérer l'enseignant à partir de la base de données en utilisant son ID
	                    Enseignant enseignant = EnseignantDAO.getEnseignantById(Integer.parseInt(enseignantId));
	                    if (enseignant != null) {
	                        // Passer l'enseignant comme attribut de la requête
	                        request.setAttribute("enseignant", enseignant);
	                        // Rediriger vers la page de modification
	                        request.getRequestDispatcher("modifierEnseignant.jsp").forward(request, response);
	                    } else {
	                        response.sendRedirect("error.jsp");
	                    }
	                } else {
	                    response.sendRedirect("error.jsp");
	                }
	                break;




	            case "delete":
	                request.getRequestDispatcher("selectionnerEnseignant.jsp").forward(request, response);
	                break;
	            case "viewAll":
	                // Mettre à jour la liste des enseignants
	                List<Enseignant> enseignantsList = EnseignantDAO.getAllEnseignants();
	                // Enregistrer la liste dans un attribut de la requête
	                request.setAttribute("enseignants", enseignantsList);
	                // Rediriger vers la liste des enseignants
	                request.getRequestDispatcher("listeEnseignants.jsp").forward(request, response);
	                break;
	            default:
	                response.sendRedirect("error.jsp");
	        }
	    }
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String action = request.getParameter("action");
	    String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    Enseignant enseignant = new Enseignant(username, email, password);

	    String idParam = request.getParameter("id");
	    if (idParam != null && !idParam.isEmpty()) {
	        int id = Integer.parseInt(idParam);
	        if (action != null) {
	            switch (action) {
	                case "editEnseignant":
	                	EnseignantDAO.update(enseignant);
	                	response.sendRedirect("AdminEnseignantServlet?action=viewAll");
	                    break;
	                case "delete":
	                    EnseignantDAO.delete(id);
	                    break;
	                default:
	                    response.sendRedirect("error.jsp");
	            }
	        }
	    } else {
	        if (action != null && action.equals("create")) {
	            EnseignantDAO.create(enseignant);
	        }
	    }

	    // Si la requête provient de la page d'ajout, rediriger vers la page d'ajout
	    if (request.getHeader("referer").contains("ajouterEnseignant.jsp")) {
	        response.sendRedirect("ajouterEnseignant.jsp");
	    } else {
	        // Sinon, mettre à jour la liste des enseignants et rediriger vers la liste des enseignants
	        List<Enseignant> enseignantsList = EnseignantDAO.getAllEnseignants();
	        request.setAttribute("enseignants", enseignantsList);
	        request.getRequestDispatcher("listeEnseignants.jsp").forward(request, response);
	    }
	}





}
