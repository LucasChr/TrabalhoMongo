package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import dao.ContaDAO;
import dao.ContaDAOMongo;
import model.Conta;

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

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("contas");
		ContaDAO dao = new ContaDAOMongo(db);

		Long numConta = Long.valueOf(conta);
		Conta c = dao.getConta(numConta);
		
		Integer nconta = c.getNumero();
		Integer convConta = Integer.valueOf(conta);
		String lsenha = c.getSenha();
		
		if (nconta.equals(convConta) && lsenha.equals(senha)) {
			request.setAttribute("conta", conta);
			request.getSession().setAttribute("contaNum", convConta);
			getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
		} else {
			RequestDispatcher dis = request.getRequestDispatcher("erroLogin.jsp");
			dis.forward(request, response);
		}

	}
}
