package tests;


import model.TrianguloRectangulo;

public class Test01 {
	public static void main(String[] args) {
		TrianguloRectangulo tr;
		tr = new TrianguloRectangulo();
		
		TrianguloRectangulo tr1 = new TrianguloRectangulo();
		
		tr1.c1 = 3;
		tr1.c2 = 4;
		System.out.println(tr1.hipotenusa());
	}
}
