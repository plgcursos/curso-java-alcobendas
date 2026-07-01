package tests;

import java.util.Scanner;

import model.Circulo;
import model.Figura;
import model.Rectangulo;

public class Test04 {
	public static void main(String[] args) {
		
		Circulo c = new Circulo(1, 2, 3);
		System.out.println(c.radio);
		
		System.out.println(c);
		
		
		Figura f = c;
		System.out.println(f.area());
//		System.out.println(f.radio);
		
		Object o = c;
		
		System.out.println(o);

		
		procesaFiguraPre17(f);
		procesaFiguraPre17(new Rectangulo(1, 2, 3, 74));
		
		procesaFiguraJava17(f);
		procesaFiguraJava17(new Rectangulo(1, 2, 3, 74));
		System.out.println("--------");
		procesaObjetoJava21(o);
		procesaObjetoJava21(new Rectangulo(1, 2, 3, 74));
		procesaObjetoJava21("hola que tal");
		procesaObjetoJava21(new Scanner(System.in));
		
	}
	
	public static void procesaFiguraPre17(Figura f) {
		System.out.println("Desde procesaFiguraPre17(...)");
		if (f instanceof Rectangulo) {
			Rectangulo otro = (Rectangulo) f;
			System.out.println("Es un rectángulo");
			System.out.println(otro.diagonal());
		}
		
		if (f instanceof Circulo) {
			Circulo nuevo = (Circulo) f;
			System.out.println("Es un círculo");
			System.out.println(nuevo.radio);
		}
	}
	
	// java 17 incorpora Pattern Matching
	public static void procesaFiguraJava17(Figura f) {
		System.out.println("Desde procesaFiguraJava17(...)");
		if (f instanceof Rectangulo otro) {
			System.out.println("Es un rectángulo");
			System.out.println(otro.diagonal());
		}
		
		if (f instanceof Circulo nuevo) {
			System.out.println("Es un círculo");
			System.out.println(nuevo.radio);
		}
	}
	
	// java 21
	public static void procesaObjetoJava21(Object o) {
		switch(o) {
		case Rectangulo r -> System.out.println(r.diagonal());
		case Circulo c -> System.out.println(c.radio);
		case String s -> System.out.println(s.toUpperCase());
		case null -> System.out.println("null");
		default -> System.out.println("Otro tipo");
		}
	}
}
