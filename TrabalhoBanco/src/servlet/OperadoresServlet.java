package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import model.TipoOperacao;

/**
 * Servlet implementation class OperadoresServlet
 */
@WebServlet("/OperadoresServlet")
public class OperadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OperadoresServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		String valor = request.getParameter("valor");
		String conta = request.getSession().getAttribute("conta").toString();

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("contas");
		ContaDAO dao = new ContaDAOMongo(db);
		// Encontra a contra que a pessoa está utilizando
		Conta contaNum = new Conta();
		contaNum = dao.getConta(conta);

		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		dt.format(new Date());

		// auxiliar para calculo de saldo
		Double saldo = 0.0;
		// Registra a operação realizada
		Operacao opr = new Operacao();
		opr.setValor(Double.valueOf(valor));
		opr.setData(dt);

		if (op.equals("") || op == null) {
			response.getWriter().append("Operação inválida! tente novamente");
			response.sendRedirect("menu.jsp");
		} else if (op.equals("credito")) {
			// Utilizando o ENUM para definir como constante o nome da operação
			opr.setTipoOpr(String.valueOf(TipoOperacao.CREDITO));
			saldo += Double.valueOf(valor);

			contaNum.setSaldo(saldo);
			dao.update(contaNum);
		} else if (op.equals("debito")) {
			opr.setTipoOpr(String.valueOf(TipoOperacao.DEBITO));

			saldo -= Double.valueOf(valor);
			contaNum.setSaldo(saldo);
			dao.update(contaNum);
		}

		request.getSession().setAttribute("saldo", saldo);
		response.sendRedirect("menu.jsp");

	}

}
