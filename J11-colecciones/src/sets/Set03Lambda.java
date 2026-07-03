package sets;

import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Set03Lambda {
	public static void main(String[] args) {
		
		Set<String> palabras = new TreeSet<String>((s1, s2) -> s1.length() - s2.length());
		palabras.add("ñalkjsadñlfkj");
		palabras.add("sadñlfkj");
		palabras.add("hfhfhfñalkjsadñlfkj");
		palabras.add("adñlfkj");
		palabras.add("fkj");
		
//		for (String palabra : palabras) {
//			System.out.println(palabra);
//		}
		
		palabras.forEach(p -> System.out.println(p));
	}
}
