package model;

public class TrianguloRectangulo {
	public double c1;
	public double c2;
	
	public double hipotenusa() {
		return Math.sqrt(c1 * c1 + c2 * c2);
	}
	
	public double area() {
		return c1 * c2 / 2;
	}
	
	public double perimetro() {
		return c1 + c2 + hipotenusa();
	}
}
