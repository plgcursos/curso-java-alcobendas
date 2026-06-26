package model;

import java.util.Objects;

public class Rectangulo extends Figura {
	public double lado1;
	public double lado2;
	
	public Rectangulo() {}
	
	public Rectangulo(double x, double y, double lado1, double lado2) {
		super(x, y);
		this.lado1 = lado1;
		this.lado2 = lado2;
	}
	
	public double diagonal() {
		return Math.sqrt(lado1 * lado1 + lado2 * lado2);
	}
	
	@Override
	public double area() {
		return lado1 * lado2;
	}
	
	@Override
	public double perimetro() {
		return 2 * (lado1 + lado2);
	}

	@Override
	public String toString() {
		return "Rectangulo [" + x + ", " + y + ", " + lado1 + ", " + lado2 + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (!super.equals(o))
			return false;
		if (o == this)
			return true;
		Rectangulo otro = (Rectangulo) o;
		return this.lado1 == otro.lado1 && this.lado2 == otro.lado2;
	}
}
