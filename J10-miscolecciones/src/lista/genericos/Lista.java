package lista.genericos;

import colecciones.genericos.Coleccion;

public interface Lista <T> extends Coleccion<T> {

	T eliminar(int pos);
	
	T buscar(int pos);

}
