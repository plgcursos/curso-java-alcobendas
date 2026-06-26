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
	public int hashCode() {
		return Objects.hash(lado1, lado2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangulo other = (Rectangulo) obj;
		return Double.doubleToLongBits(lado1) == Double.doubleToLongBits(other.lado1)
				&& Double.doubleToLongBits(lado2) == Double.doubleToLongBits(other.lado2);
	}
	
}
