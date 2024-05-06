package view;



import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InscriptionView
 */
public class InscriptionView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>Insert title here</title>\r\n" + "</head>\r\n" + "<body>\r\n" + "\r\n"
				+ "	<form method=\"post\" action=\"LoginServlet\">\r\n" + "		<table>\r\n"
				+ "			<tr>\r\n" + "				<td>Nom :</td>\r\n"
				+ "				<td><input name=\"nom\"></td>\r\n" + "			</tr>\r\n" + "			<tr>\r\n"
				+ "				<td>Prénom :</td>\r\n"
				+ "				<td><input type=\"text\" name=\"prenom\"></td>\r\n" + "			</tr>\r\n"
				+ "			<tr>\r\n" + "				<td>Login :</td>\r\n"
				+ "				<td><input name=\"login\"></td>\r\n" + "			</tr>\r\n" + "			<tr>\r\n"
				+ "				<td>Mot de passe :</td>\r\n"
				+ "				<td><input type=\"password\" name=\"pwd\"></td>\r\n" + "			</tr>\r\n"
				+ "			<tr>\r\n" + "				<td><input type=\"submit\" value=\"valider\"></td>\r\n"
				+ "				<td><input type=\"reset\" value=\"annuler\"></td>\r\n" + "			</tr>\r\n"
				+ "		</table>\r\n" + "	</form>\r\n" + "</body>\r\n" + "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
