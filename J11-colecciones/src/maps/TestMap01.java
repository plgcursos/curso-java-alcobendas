package maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap01 {
	public static void main(String[] args) {
		TreeMap<Integer, String> map1 = new TreeMap<>();
		testMapas(map1);
		
		HashMap<Integer, String> hashM = new HashMap<Integer, String>();
		testMapas(hashM);
		
		LinkedHashMap<Integer, String> linkHashM = new LinkedHashMap<Integer, String>();
		testMapas(linkHashM);
	}
	
	
	
	public static void testMapas(Map<Integer, String> mapa) {
		System.out.println(mapa.getClass().getSimpleName());
		mapa.put(159, "Ciento cincuenta y nueve");
		mapa.put(15, "Quince");
		mapa.put(1, "Uno");
		mapa.put(10, "Diez");
		
		String buscado = mapa.get(10);
		String otro = mapa.get(107);
		
		System.out.println(buscado);
		System.out.println(otro);
		System.out.println();

		// Pedir las claves
		// keySet() : Set<Integer>
		for (Integer key : mapa.keySet()) {
			System.out.println(key);
		}
		
		System.out.println("------------------");
		
	}
}
