package dao;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.mongodb.DB;

import model.Cliente;

public class ClienteDAOMongo implements ClienteDAO {

	private final DB db;

	public ClienteDAOMongo(DB db) {
		this.db = db;
	}

	public MongoCollection cliente() {
		Jongo jongo = new Jongo(db);
		return jongo.getCollection("cliente");
	}

	@Override
	public void inserir(Cliente cliente) {
		cliente().save(cliente);
	}

}
