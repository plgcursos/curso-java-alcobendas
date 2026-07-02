package colecciones.genericos;

public interface Coleccion <T> {

	void agregar(T dato);
	
	boolean estaVacia();
	
	int largo();

	T eliminar (T elem);
}
