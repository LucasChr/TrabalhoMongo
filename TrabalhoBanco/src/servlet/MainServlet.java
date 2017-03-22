package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String conta = request.getParameter("conta");
		String senha = request.getParameter("senha");

		if (conta.equals("") && senha.equals("")) {
			response.getWriter().append("Dados inválidos!");
		} else {
			request.setAttribute("conta", conta);
			
			getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
		}

	}

}
