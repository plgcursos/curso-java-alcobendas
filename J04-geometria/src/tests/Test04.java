package tests;

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
		
		Object o = c;
		
		System.out.println(o);

		Rectangulo otro;
		if (o instanceof Rectangulo)
			otro = (Rectangulo)o;
		
	}
}
