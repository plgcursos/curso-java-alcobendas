package prueba;

public class Coche {
	private String titular;
	private final String MARCA;
	private final String MODELO;
	
	public static final int SEDAN = 1;
	public static final int DESCAPOTABLE = 2;
	
	// 1 - Sedan
	// 2 - Descapotable
	private int tipo;
	
	public Coche(String titular, String MARCA, String MODELO, int tipo) {
		this.titular = titular;
		this.MARCA = MARCA;
		this.MODELO = MODELO;
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getMARCA() {
		return MARCA;
	}
	
//	No se puede cambiar el valor de un atributo final
//	public void setMARCA(String MARCA) {
//		this.MARCA = MARCA;
//	}

	public String getMODELO() {
		return MODELO;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
