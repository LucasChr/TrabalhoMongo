package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import model.Cliente;
import model.Conta;
import model.Operacao;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String numero = request.getParameter("conta");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String renda = request.getParameter("renda");

		if (numero.equals("") && nome.equals("") && cpf.equals("") && renda.equals("")) {
			response.getWriter().append("Favor preencher todos os campos!!");
		} else {
			MongoClient mongo = new MongoClient();
			DB db = mongo.getDB("contas");

			ContaDAO contaDAO = new ContaDAOMongo(db);

			Cliente cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setCpf(Integer.valueOf(cpf));
			cliente.setRenda(Double.valueOf(renda));

			List<Operacao> operacoes = new ArrayList<>(); 			
			Conta conta2 = new Conta();
			conta2.setNumero(Integer.valueOf(numero));
			conta2.setCliente(cliente);
			conta2.setSenha(senha);
			conta2.setSaldo(Double.valueOf(renda));
			conta2.setOperacaoList(operacoes);

			contaDAO.inserir(conta2);

			mongo.close();
			
			request.setAttribute("conta", conta2);
			
			getServletContext().getRequestDispatcher("/cadastroSucesso.jsp").forward(request, response);
		}

	}

}
