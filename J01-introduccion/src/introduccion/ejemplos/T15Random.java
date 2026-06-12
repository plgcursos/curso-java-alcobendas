package introduccion.ejemplos;

import java.util.Random;

public class T15Random {
	public static void main(String[] args) {
		
		
		for (int i = 1; i <= 100; i++) {
			System.out.println(Math.random());
		}
		System.out.println("==========================");
		
		// Generar el lanzmiento de un dado
		for (int i = 1; i <= 100; i++) {
			System.out.println((int)(Math.ceil(Math.random() * 6)));
		}
		System.out.println("==========================");

		// Generar numeros en un rango
		int desde = 2005;
		int hasta = 2026;

		for (int i = 1; i <= 100; i++) {
			System.out.println((int)(Math.floor(Math.random() * (hasta - desde + 1))) + desde );
		}
		
		// Usando Random
		Random rand = new Random();
		for (int i = 1; i <= 100; i++) {
			System.out.println(rand.nextInt(desde, hasta + 1));
		}
		
		
	}
}
