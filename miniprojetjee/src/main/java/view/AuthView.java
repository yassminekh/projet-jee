package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthView
 */
public class AuthView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean erreur = false;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<p align=\"left\"><a href=\"InscriptionView\">Inscription</a></p>"
				+ "	<form method=\"post\" action=\"AuthController\">\r\n");
//		if(request.getParameter("error")!=null) {
//			out.println("Veuillez vérifier vos paramètres !!!");
//		}
		if(request.getAttribute("erreur")!=null) {
			out.println(request.getAttribute("erreur"));
		}
		out.println("		<table>\r\n"
				+ "			<tr>\r\n"
				+ "				<td>Login :</td>\r\n"
				+ "				<td><input name=\"login\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td>Mot de passe :</td>\r\n"
				+ "				<td><input type=\"password\" name=\"pwd\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "			<tr>\r\n"
				+ "				<td><input type=\"submit\" value=\"valider\"></td>\r\n"
				+ "				<td><input type=\"reset\" value=\"annuler\"></td>\r\n"
				+ "			</tr>\r\n"
				+ "		</table>\r\n"
				+ "	</form>\r\n"
				+ "</body>\r\n"
				+ "</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
