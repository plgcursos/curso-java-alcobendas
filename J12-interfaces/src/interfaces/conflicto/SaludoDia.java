package interfaces.conflicto;

public interface SaludoDia {
	
	default void saluda() {
		System.out.println("Buenos días");
	}
}
