package es.cursoalcobendas.jpa.ej07_herenciajoined;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "figuras02")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Figura2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idfigura")
	private int idFigura;
	private double x;
	private double y;
	
	public Figura2() {
		super();
	}
	
	public Figura2(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double distanciaCentro() {
		return Math.sqrt(x * x + y * y);
	}
	
	public abstract double area();

	public abstract double perimetro();
	
	public int getIdFigura() {
		return idFigura;
	}

	public void setIdFigura(int idFigura) {
		this.idFigura = idFigura;
	}

	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFigura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figura2 other = (Figura2) obj;
		return idFigura == other.idFigura;
	}
	
}
