package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/tirageServlet")
public class TirageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String document = request.getParameter("document");
        int copies = Integer.parseInt(request.getParameter("copies"));
        
      
        response.sendRedirect("confirmation.jsp");
    }
}
