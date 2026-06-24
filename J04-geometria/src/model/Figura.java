package model;

public class Figura {

	public double x;
	public double y;
	
	public Figura() {
		super();
	}
	
	public Figura(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double distanciaCentro() {
		return Math.sqrt(x * x + y * y);
	}
	
	public double area() {
		return 0;
	}

	public double perimetro() {
		return 0;
	}
}
