package tests;

import model.Circulo;

public class Test05Equals {
	public static void main(String[] args) {
		
		Circulo c1 = new Circulo(1,2,3);
		Circulo c2 = new Circulo(1,2,3);
		
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		
	}
}
