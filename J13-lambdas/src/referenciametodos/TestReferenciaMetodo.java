package referenciametodos;

import java.util.List;

public class TestReferenciaMetodo {
	public static void main(String[] args) {
		
		List<String> nombres = List.of("Santi", "Geor", "Oscar", "Borja", "Marta", "Dani", "Ruben", "Dani", "Manuel");
		List<Integer> nums = List.of(10, 27, -33, -9, 158);
		
		nombres.forEach(System.out::println);
		System.out.println();
		
		
		//Referencia a método estático
			//Listar el valor absoluto de los nums
			
			//Utilizando una lambda
			nums.forEach(n -> System.out.println(Math.abs(n)));
			System.out.println();
			
			//Utilizando stream/map/referencia a método
			nums.stream().map(Math::abs).forEach(System.out::println);
			System.out.println();
		
		//Referencia a método estático propio
		nombres.forEach(TestReferenciaMetodo::muestraCantLetras);
		System.out.println();
		
		//Referencia a método de instancia de un objeto existente
		String saludo = "Buenas tardes ";
		System.out.println(saludo.concat("Pablo"));
		
		nombres.stream().map(saludo::concat).forEach(System.out::println);
		System.out.println();
		
		//Referencia a método de instancia de un tipo
		nombres.stream().map(String::toUpperCase).map(saludo::concat).forEach(System.out::println);
		System.out.println();
		nombres.stream().map(saludo::concat).map(String::toUpperCase).forEach(System.out::println);
		System.out.println();
		
		//Referencia a método constructor
		List<Alumno> alumnos = nombres.stream().map(Alumno::new).toList();
		alumnos.forEach(System.out::println);
	}
	
	public static void muestraCantLetras(String s) {
		System.out.println(s.length());
	}
}
