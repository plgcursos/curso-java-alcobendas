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
	
	@Override
	public String toString() {
		return "Circulo(" + x + ", " + y + ", " + radio + ")";
	}
	
	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		if (this == o)
			return true;
		Circulo otro = (Circulo)o;
		return this.radio == otro.radio;
	}
}
