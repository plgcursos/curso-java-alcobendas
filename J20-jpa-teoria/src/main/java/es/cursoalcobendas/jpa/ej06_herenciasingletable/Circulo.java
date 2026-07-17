package es.cursoalcobendas.jpa.ej06_herenciasingletable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CIRCULO")
public class Circulo extends Figura {

	@Column(name = "r")
	private double radio;
	
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
