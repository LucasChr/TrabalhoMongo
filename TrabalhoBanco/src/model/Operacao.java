package model;

import java.util.Date;

public class Operacao {

	private Double valor;
	private Date data;
	private String tipoOpr;

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

	public String getTipoOpr() {
		return tipoOpr;
	}

	public void setTipoOpr(String tipoOpr) {
		this.tipoOpr = tipoOpr;
	}

}
