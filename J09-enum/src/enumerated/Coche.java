package enumerated;

public class Coche {

	private String titular;
	private TipoCoche tipo;
	
	public Coche(String titular, TipoCoche tipo) {
		this.titular = titular;
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public TipoCoche getTipo() {
		return tipo;
	}

	public void setTipo(TipoCoche tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
