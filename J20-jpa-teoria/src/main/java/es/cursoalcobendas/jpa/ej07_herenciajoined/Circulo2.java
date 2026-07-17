package es.cursoalcobendas.jpa.ej07_herenciajoined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "circulo_02")
public class Circulo2 extends Figura2 {

	@Column(name = "r")
	private double radio;
	
	public Circulo2() {}
	
	public Circulo2(double x, double y, double radio) {
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
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo(" + getX() + ", " + getY() + ", " + radio + ")";
	}
	

}
