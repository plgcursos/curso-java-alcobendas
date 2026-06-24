package model;

public class Circulo extends Figura {

	public double radio;
	
	public Circulo() {}
	
	public Circulo(double x, double y, double radio) {
		super(x, y);
		this.radio = radio;
	}
	
	public double diametro() {
		return radio * 2;
	}
	
	@Override
	public double area() {
		return Math.PI * radio * radio;
	}
	
	@Override
	public double perimetro() {
		return Math.PI * diametro();
	}
}
