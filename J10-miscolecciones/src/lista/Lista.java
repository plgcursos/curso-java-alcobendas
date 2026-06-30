package lista;

public interface Lista {

	void agregar(String dato);
	
	String eliminar(int pos);
	
	String buscar(int pos);
	
	boolean estaVacia();
	
	int largo();
}
