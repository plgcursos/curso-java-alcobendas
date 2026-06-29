package model;

import java.util.Objects;

import model.rrhh.Printable;

public class Rombo extends Figura implements Printable {

	private double dMayor;
	private double dMenor;
	
	public Rombo() {
	}

	public Rombo(double x, double y, double dMayor, double dMenor) {
		super(x, y);
		this.dMayor = dMayor;
		this.dMenor = dMenor;
	}

	@Override
	public double area() {
		return dMayor * dMenor / 2;
	}

	@Override
	public double perimetro() {
		return 2 * Math.sqrt(dMayor * dMayor + dMenor * dMenor);
	}

	public double getdMayor() {
		return dMayor;
	}

	public void setdMayor(double dMayor) {
		this.dMayor = dMayor;
	}

	public double getdMenor() {
		return dMenor;
	}

	public void setdMenor(double dMenor) {
		this.dMenor = dMenor;
	}

	@Override
	public String toString() {
		return "Rombo [" + getX() + ", " + getY() + ", " + dMayor + ", " + dMenor + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dMayor, dMenor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		Rombo other = (Rombo) obj;
		return Double.doubleToLongBits(dMayor) == Double.doubleToLongBits(other.dMayor)
				&& Double.doubleToLongBits(dMenor) == Double.doubleToLongBits(other.dMenor);
	}

	@Override
	public void print() {
		System.out.println("soy un rombo!!");
	}

}
