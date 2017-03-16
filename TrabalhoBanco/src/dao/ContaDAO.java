package dao;

import model.Conta;

public interface ContaDAO {

	void inserir(Conta conta);
	
	Conta porNumero(Long numero);
}
