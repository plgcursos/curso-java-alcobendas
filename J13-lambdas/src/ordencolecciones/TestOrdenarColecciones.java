package ordencolecciones;

import java.util.Comparator;
import java.util.List;

public class TestOrdenarColecciones {
	public static void main(String[] args) {
		List<String> nombres = List.of("Santiago Andrés", "Geor", "Oscar", "Borja", "Marta Angela", "Daniel David", "Ruben", "Dani", "Manuel Enrique");
		List<Integer> nums = List.of(10, 27, -33, -9, 158);

		//Obtener nombres ordenados
		nombres.stream().sorted().forEach(System.out::println); 
		System.out.println();
		
		//Obtener una lista de nombres ordenados por cantidad de letras
		List<String> nombresLargo = nombres.stream().sorted((s1,s2)->s1.length()-s2.length()).toList();
		nombresLargo.forEach(System.out::println);
		System.out.println();
		
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		};
		
		nombres.stream().sorted(comp).forEach(System.out::println);
		System.out.println();
		
		nombres.stream()
			.filter(s -> s.length() > 5)
			.sorted(Comparator.comparing(String::length).reversed())
			.forEach(System.out::println);
	}
}
