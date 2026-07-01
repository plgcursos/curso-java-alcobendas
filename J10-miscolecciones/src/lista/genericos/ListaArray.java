package lista.genericos;

public class ListaArray<T> implements Lista<T> {
	
	private Object[] almacen;
	private int cant;
	
	public ListaArray(int tam) {
		almacen = new Object[tam];
	}
	
	public ListaArray() {
		this(10);
	}

	private void redimensionar() {
		Object[] nuevo = new Object[almacen.length * 2];
		for (int i = 0; i < almacen.length; i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}
	
	@Override
	public void agregar(T dato) {
		if (almacen.length == cant)
			redimensionar();
		almacen[cant++] = dato;
	}

	@Override
	public T eliminar(int pos) {
		if (pos < 0 || pos >= cant)
			return null;
		
		@SuppressWarnings("unchecked")
		T eliminado = (T)almacen[pos];
		for (int i = pos; i < cant - 1; i++) {
			almacen[i] = almacen[i + 1];
		}
		cant--;
		return eliminado;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscar(int pos) {
		if (pos >= 0 && pos < cant)
			return (T)almacen[pos];
		return null;
	}

	@Override
	public boolean estaVacia() {
		return cant == 0;
	}

	@Override
	public int largo() {
		return cant;
	}

}
