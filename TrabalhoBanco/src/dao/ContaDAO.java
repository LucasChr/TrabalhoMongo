package dao;

import java.util.List;

import model.Conta;

public interface ContaDAO {

	void inserir(Conta conta);

	void update(Conta conta);

	List<Conta> todos();

	Conta getConta(Long conta);
}
