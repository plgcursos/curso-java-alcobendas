package tests;


import model.TrianguloRectangulo;

public class Test01 {
	public static void main(String[] args) {
		TrianguloRectangulo tr;
		tr = new TrianguloRectangulo();
		
		TrianguloRectangulo tr1 = new TrianguloRectangulo();
		tr1.c1 = 3;
		tr1.c2 = 4;
		muestraTriangulo(tr1);
		
		tr.c1 = 4.5;
		tr.c2 = 6;
		muestraTriangulo(tr);
	}
	
	public static void muestraTriangulo(TrianguloRectangulo t) {
		System.out.println("Triangulo rectángulo de catetos " + t.c1 + " y " + t.c2);
		System.out.println("Hip: " + t.hipotenusa());
		System.out.println("Area: " + t.area());
		System.out.println("Perim: " + t.perimetro());
	}
}
