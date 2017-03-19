package model;

public class Cliente {

	private Conta conta;
	private String nome;
	private Integer cpf;
	private Double renda;

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta codigo) {
		this.conta = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

}
