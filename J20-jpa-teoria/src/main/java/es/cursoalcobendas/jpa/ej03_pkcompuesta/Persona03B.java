package es.cursoalcobendas.jpa.ej03_pkcompuesta;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona_03")
public class Persona03B implements Serializable {

	@EmbeddedId
	private Dni dni;
	private String nombre;
	
	public Persona03B() {
		System.out.println("Alguien ha llamado al constructor por defecto Persona03B()");
	}
	
	public Persona03B(Dni dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
	}

	public Persona03B(int nroDoc, char letraDoc, String nombre) {
		this.dni = new Dni(nroDoc, letraDoc);
		this.nombre = nombre;
	}

	public int getNroDoc() {
		return dni.getNroDoc();
	}

	public void setNroDoc(int nroDoc) {
		this.dni.setNroDoc(nroDoc);
	}

	public char getLetraDoc() {
		return dni.getLetraDoc();
	}

	public void setLetraDoc(char letraDoc) {
		this.dni.setLetraDoc(letraDoc);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona03B other = (Persona03B) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return "Persona03 [" + dni.getNroDoc() + ", " + dni.getLetraDoc() + ", " + nombre + "]";
	}
}
