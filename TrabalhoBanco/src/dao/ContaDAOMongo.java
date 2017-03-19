package dao;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;

import model.Conta;

public class ContaDAOMongo implements ContaDAO {

	private final DB db;

	public ContaDAOMongo(DB db) {
		this.db = db;
	}

	public MongoCollection conta() {
		Jongo jongo = new Jongo(db);
		return jongo.getCollection("contas");
	}

	@Override
	public void inserir(Conta conta) {
		conta().save(conta);
	}

	@Override
	public void update(Conta conta) {
		conta().update("{numero: #}", conta.getNumero());
	}

	@Override
	public Conta getConta(String conta) {
		return conta().findOne("{numero: #}", conta).as(Conta.class);
	}

}
