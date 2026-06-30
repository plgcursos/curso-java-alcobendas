package lista;

public class ListaEnlazada implements Lista {

	private Nodo primero;
	private Nodo ultimo;
	private int cant;
	
	@Override
	public void agregar(String dato) {
		Nodo nuevo = new Nodo(dato);
		if(primero == null)
			primero = nuevo;
		else
			ultimo.siguiente = nuevo;
		ultimo = nuevo;
		cant++;
	}

	@Override
	public String eliminar(int pos) {
		if (pos < 0 || pos >= cant)
			return null;
		
		String dato;
		if (pos == 0) {
			dato = primero.dato;
			primero = primero.siguiente;
			if (primero == null)
				ultimo = null;
			cant --;
			return dato;
		}
		
		Nodo ant = anterior(pos);
		dato = ant.siguiente.dato;
		
		if (pos == cant -1) {
			ant.siguiente = null;
			ultimo = ant;
			cant--;
			return dato;
		}
		
		ant.siguiente = ant.siguiente.siguiente;
		cant --;
		return dato;
	}

	@Override
	public String buscar(int pos) {
		if (pos < 0 || pos >= cant)
			return null;
		if (pos == 0)
			return primero.dato;
		if (pos == cant -1)
			return ultimo.dato;
		Nodo ant = anterior(pos);
		Nodo buscado = ant.siguiente;
		return buscado.dato;
		
	}
	
	private Nodo anterior(int pos) {
		Nodo aux = primero;
		for (int i = 0; i < pos - 1; i++) {
			aux = aux.siguiente;
		}
		return aux;
	}

	@Override
	public boolean estaVacia() {
		return cant == 0;
	}

	@Override
	public int largo() {
		return cant;
	}

	private class Nodo {
		String dato;
		Nodo siguiente;
		
		Nodo(String dato){
			this.dato = dato;
		}
	}
	
}
