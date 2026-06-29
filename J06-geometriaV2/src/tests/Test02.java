package tests;

import model.Circulo;

public class Test02 {
	public static void main(String[] args) {
		Circulo c = new Circulo(15, -3.5, 5);
		
		System.out.println(c.getX());
		System.out.println(c.getY());
		System.out.println(c.getRadio());
		
		Circulo[] circulos = {
			new Circulo(1, 2, 3), 
			new Circulo(-0.5, 2.75, 14.85), 
			new Circulo(0, 1.7, 3.5), 
			new Circulo(-11, 22, 33)
		};
		
		for (int i = 0; i < circulos.length; i++) {
			System.out.println(circulos[i].area());
		}
	}
}
