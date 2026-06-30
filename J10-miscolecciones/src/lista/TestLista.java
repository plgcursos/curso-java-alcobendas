package lista;

public class TestLista {
	public static void main(String[] args) {
//		ListaArray la = new ListaArray();
		ListaEnlazada la = new ListaEnlazada();
		la.agregar("uno");
		la.agregar("dos");
		la.agregar("3");
		la.agregar("4");
		la.agregar("5");
		la.agregar("6");
		la.agregar("7");
		la.agregar("8");
		la.agregar("9");
		la.agregar("10");
		la.agregar("11");
		System.out.println(la.largo());
		
		la.eliminar(5);
		
		recorre(la);
	}
	
	public static void recorre(Lista lista) {
		for (int i = 0; i < lista.largo(); i++) {
			System.out.println(lista.buscar(i));
		}
	}
}
