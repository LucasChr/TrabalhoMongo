package dao;

import model.Conta;

public interface ContaDAO {

	void inserir(Conta conta);

	void update(Conta conta);

	Conta getConta(String conta);
}
