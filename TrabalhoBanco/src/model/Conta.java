package model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

public class Conta {

	private ObjectId _id;
	private Integer numero;
	private String senha;
	private Cliente cliente;
	private Double saldo;
	List<Operacao> operacaoList = new ArrayList<>();

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public List<Operacao> getOperacaoList() {
		return operacaoList;
	}

	public void setOperacaoList(List<Operacao> operacaoList) {
		this.operacaoList = operacaoList;
	}

}
