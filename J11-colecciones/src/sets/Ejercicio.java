package sets;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio {
	public static void main(String[] args) {
		
		Set<String> palabras = new TreeSet<String>();
		palabras.add("ñalkjsadñlfkj");
		palabras.add("sadñlfkj");
		palabras.add("hfhfhfñalkjsadñlfkj");
		palabras.add("adñlfkj");
		palabras.add("fkj");
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
		System.out.println();
		
		Set<String> palabras2 = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		palabras2.addAll(palabras);
		
		for (String palabra : palabras2) {
			System.out.println(palabra);
		}
	}
}
