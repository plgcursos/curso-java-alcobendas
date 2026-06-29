package tests;

import model.Circulo;
import model.Rectangulo;

public class Test01 {
	public static void main(String[] args) {
		Circulo c = new Circulo(30, -40, 15.75);
		
//		c.x = 30;
//		c.y = -40;
//		c.radio = 15.75;
		System.out.println(c.distanciaCentro());
		System.out.println(c.area());
		System.out.println(c.diametro());
		
		Rectangulo r = new Rectangulo();
//		r.x = 2.5;
		r.setX(2.5);
//		r.y = 0;
		r.setY(0);
//		r.lado1 = 12;
		r.setLado1(12);
//		r.lado2 = 7;
		r.setLado2(7);
		System.out.println(r.area());
		System.out.println(r.perimetro());
		System.out.println(r.diagonal());
		System.out.println(r.distanciaCentro());
		
		
	}
}
