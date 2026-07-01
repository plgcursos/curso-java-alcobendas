package lista.genericos;

public interface Lista <T> {

	void agregar(T dato);
	
	T eliminar(int pos);
	
	T buscar(int pos);
	
	boolean estaVacia();
	
	int largo();
}
