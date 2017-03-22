package dao;

import java.util.ArrayList;
import java.util.List;

import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.jongo.MongoCursor;

import com.mongodb.DB;

import model.Conta;

public class ContaDAOMongo implements ContaDAO {

	private final DB db;

	public ContaDAOMongo(DB db) {
		this.db = db;
	}

	public MongoCollection contas() {
		Jongo jongo = new Jongo(db);
		return jongo.getCollection("contas");
	}

	@Override
	public void inserir(Conta conta) {
		contas().save(conta);
	}

	@Override
	public void update(Conta conta) {
		contas().update("{numero: #}", conta.getNumero()).with(conta);
	}

	@Override
	public Conta getConta(Long numero) {
		return contas().findOne("{numero: #}", numero).as(Conta.class);
	}

	@Override
	public List<Conta> todos() {
		MongoCursor<Conta> cursorConta = contas().find().as(Conta.class);
		List<Conta> contasList = new ArrayList<>();
		cursorConta.forEach(conta -> contasList.add(conta));
		return contasList;
	}

}
