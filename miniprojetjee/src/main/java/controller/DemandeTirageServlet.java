package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DemandeTirage;

@WebServlet("/demandeTirage")
public class DemandeTirageServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matiere = request.getParameter("matiere");
        String document = request.getParameter("document");
        int nombreCopies = Integer.parseInt(request.getParameter("nombreCopies")); 
        DemandeTirage demandeTirage = new DemandeTirage(matiere, document, nombreCopies);
        request.getSession().setAttribute("demandeTirage", demandeTirage);
        response.sendRedirect("confirmation.jsp");
    }
}
