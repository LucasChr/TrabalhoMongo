package servlet;

import java.io.IOException;
import java.util.Date;
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
		String numConta = request.getParameter("conta");

		MongoClient mongo = new MongoClient();
		DB db = mongo.getDB("contas");
		ContaDAO dao = new ContaDAOMongo(db);

		// Encontra a conta que a pessoa está utilizando
		Long conta = Long.valueOf(numConta);
		Conta contaNum = dao.getConta(conta);

		Date data = new Date();

		// auxiliar para calculo de saldo
		Double saldo = contaNum.getSaldo();
		Double oprValor = Double.valueOf(valor);
		// Registra a operação realizada
		Operacao opr = new Operacao();
		opr.setValor(Double.valueOf(valor));
		opr.setData(data);

		if (op.equals("") || op == null) {
			response.getWriter().append("Operação inválida! tente novamente");
		} else if (op.equals("credito")) {
			// Utilizando o ENUM para definir como constante o nome da operação
			opr.setTipoOpr(String.valueOf(TipoOperacao.CREDITO));
			saldo += oprValor;

			contaNum.setSaldo(saldo);
		} else if (op.equals("debito")) {
			opr.setTipoOpr(String.valueOf(TipoOperacao.DEBITO));

			saldo -= oprValor;

			if (saldo < 0) {
				response.getWriter().append("Saldo insuficiente");
			} else {
				contaNum.setSaldo(saldo);

			}
		}
		// fazer lista de operacoes.
		List<Operacao> contasList = contaNum.getOperacaoList();
		contasList.add(opr);
		contaNum.setOperacaoList(contasList);
		dao.update(contaNum);
		response.sendRedirect("index.jsp");

	}

}
