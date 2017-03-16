package model;

import java.util.Date;

public class Operadores {

	private Double valor;
	private Date data;
	private TipoOperacao debito;
	private TipoOperacao credito;

	public TipoOperacao getDebito() {
		return debito;
	}

	public void setDebito(TipoOperacao debito) {
		this.debito = debito;
	}

	public TipoOperacao getCredito() {
		return credito;
	}

	public void setCredito(TipoOperacao credito) {
		this.credito = credito;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
