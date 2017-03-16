package model;

public enum TipoOperacao {

	DEBITO(true, false), CREDITO(false, true);
	
	TipoOperacao(boolean debito, boolean credito){
		this.debito = debito;
		this.credito = credito;
	}
	
	private boolean debito;
	private boolean credito;
	
	
	public boolean isDebito() {
		return debito;
	}
	public void setDebito(boolean debito) {
		this.debito = debito;
	}
	public boolean isCredito() {
		return credito;
	}
	public void setCredito(boolean credito) {
		this.credito = credito;
	}
}
