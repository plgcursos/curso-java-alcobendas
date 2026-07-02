package lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lista01 {
	public static void main(String[] args) {
		
		List<String> lista = new ArrayList<>();
		lista.add("uno");
		lista.add("dos");
		lista.add("tres");
		recorre(lista);
		
		List<String> otra = new LinkedList<>(lista);
		recorre(otra);
	}
	
	// El que ha programado esto que pase por RRHH
	public static void recorre(List<String> lista) {
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}
