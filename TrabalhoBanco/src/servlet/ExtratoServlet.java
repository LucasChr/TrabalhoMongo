package servlet;

import java.io.IOException;
import java.util.List;

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
import model.Operacao;

/**
 * Servlet implementation class extratoServlet
 */
@WebServlet("/ExtratoServlet")
public class ExtratoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExtratoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Object numConta = request.getSession().getAttribute("contaNum");

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("contas");

		ContaDAO dao = new ContaDAOMongo(db);

		// Encontra a conta que a pessoa está utilizando
		Long conta = Long.valueOf(numConta.toString());
		Conta contaNum = dao.getConta(conta);

		List<Operacao> listaOpr = contaNum.getOperacaoList();

		mongo.close();
		request.setAttribute("extrato", listaOpr);
		getServletContext().getRequestDispatcher("/extrato.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
