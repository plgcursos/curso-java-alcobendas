package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Lista02Recorre {
	public static void main(String[] args) {
		List<String> al = new ArrayList<>();
		List<String> ll = new LinkedList<>();
		
		long t0, tf;
		int cant = 200_000;
		
		cargaLista(al, cant);
		cargaLista(ll, cant);
		
		t0 = System.currentTimeMillis();
//		recorre(al);
//		recorreIterator(al);
		recorreForEach(al);
		tf = System.currentTimeMillis();
		System.out.println("ArrayList: " + (tf - t0));
		
		t0 = System.currentTimeMillis();
//		recorre(ll);
//		recorreIterator(ll);
		recorreForEach(ll);
		tf = System.currentTimeMillis();
		System.out.println("LinkedList: " + (tf - t0));
	}
	
	// El que ha programado esto que pase por RRHH
	public static void recorre(List<String> lista) {
		String elemento;
		for (int i = 0; i < lista.size(); i++) {
			elemento = lista.get(i);
		}
	}
	
	public static void recorreIterator(List<String> lista) {
		String elemento;
		Iterator<String> it = lista.iterator();
		while(it.hasNext()) {
			elemento = it.next();
		}
	}
	
	public static void recorreForEach(List<String> lista) {
		for (String elemento : lista) {
			//trabajo con elemento
		}
	}

	private static void cargaLista(List<String> lista, int cant) {
		for (int i = 1; i <= cant; i++) {
			lista.add("hola que tal");
		}
	}
}
