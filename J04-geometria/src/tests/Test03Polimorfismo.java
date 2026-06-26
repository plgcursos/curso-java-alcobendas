package tests;

import model.Circulo;
import model.Figura;
import model.Rectangulo;

public class Test03Polimorfismo {
	public static void main(String[] args) {
		Circulo c1 = new Circulo(1, 2, 3);
		Circulo c2 = new Circulo(44, 5, 21);
		Rectangulo r1 = new Rectangulo(0, 0, 15, 3);
		
		System.out.println(sumaAreas(c1, r1, c2));
		
	}
	
	public static double sumaAreas(Figura... figuras) {
		double suma = 0;
		for (int i = 0; i < figuras.length; i++) {
			suma += figuras[i].area();
		}
		return suma;
	}
}
