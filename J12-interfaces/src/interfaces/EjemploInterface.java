package interfaces;

//@FunctionalInterface
//Una interfaz funcional debe tener un y sólo un método abstracto
public interface EjemploInterface {

	int ALGO = 15; //public static final
	
	void procesa(String algo);  //public abstract
	public abstract String otroProceso();
	
	default void haceAlgo() {
		System.out.println("Soy un método default");
	}
	
	default void haceOtraCosa() {
		System.out.println("Soy otro método default");
		metodoPrivado();
	}
	
	static void haceAlgoEstatico() {
		System.out.println("Soy un método estático");
		metodoPrivadoEstatico();
	}
	
	private void metodoPrivado() {
		System.out.println("Soy un método privado (default)");
	}
	
	private static void metodoPrivadoEstatico() {
		System.out.println("Soy un método privado estático");
	}
}
