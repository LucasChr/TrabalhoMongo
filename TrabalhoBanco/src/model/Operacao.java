package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Operacao {

	private Double valor;
	private SimpleDateFormat data;
	private String tipoOpr;
	List<Operacao> operacaoList = new ArrayList<>();

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public SimpleDateFormat getData() {
		return data;
	}

	public void setData(SimpleDateFormat data) {
		this.data = data;
	}

	public String getTipoOpr() {
		return tipoOpr;
	}

	public void setTipoOpr(String tipoOpr) {
		this.tipoOpr = tipoOpr;
	}

	public List<Operacao> getOperacaoList() {
		return operacaoList;
	}

	public void setOperacaoList(List<Operacao> operacaoList) {
		this.operacaoList = operacaoList;
	}

}
