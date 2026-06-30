package lista;

public class ListaArray implements Lista {
	
	private String[] almacen;
	private int cant;
	
	public ListaArray(int tam) {
		almacen = new String[tam];
	}
	
	public ListaArray() {
		this(10);
	}

	private void redimensionar() {
		String[] nuevo = new String[almacen.length * 2];
		for (int i = 0; i < almacen.length; i++) {
			nuevo[i] = almacen[i];
		}
		almacen = nuevo;
	}
	
	@Override
	public void agregar(String dato) {
		if (almacen.length == cant)
			redimensionar();
		almacen[cant++] = dato;
	}

	@Override
	public String eliminar(int pos) {
		if (pos < 0 || pos >= cant)
			return null;
		
		String eliminado = almacen[pos];
		for (int i = pos; i < cant - 1; i++) {
			almacen[i] = almacen[i + 1];
		}
		cant--;
		return eliminado;
	}

	@Override
	public String buscar(int pos) {
		if (pos >= 0 && pos < cant)
			return almacen[pos];
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
