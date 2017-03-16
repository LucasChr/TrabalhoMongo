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
		return jongo.getCollection("conta");
	}

	@Override
	public void inserir(Conta conta) {
		conta().save(conta);
	}

	@Override
	public Conta porNumero(Long numero) {
		return conta().findOne("{conta: #}", numero).as(Conta.class);
	}

}
