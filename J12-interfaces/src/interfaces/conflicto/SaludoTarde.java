package interfaces.conflicto;

public interface SaludoTarde {
	
	default void saluda() {
		System.out.println("Buenas tardes");
	}
}
