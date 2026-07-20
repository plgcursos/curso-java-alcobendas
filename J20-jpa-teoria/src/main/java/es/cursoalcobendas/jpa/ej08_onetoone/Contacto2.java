package es.cursoalcobendas.jpa.ej08_onetoone;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	
	@OneToOne
	@JoinColumn(name = "iddomicilio")
	private Domicilio2 domicilio;
	
	public Contacto2() {}

	public Contacto2(String nombre, String apellidos, String apodo, Domicilio2 domicilio) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.domicilio = domicilio;
	}

	public int getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}


	public Domicilio2 getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio2 domicilio) {
		this.domicilio = domicilio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	public String getNombreCompleto() {
		return apellidos + ", " + nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idContacto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacto2 other = (Contacto2) obj;
		return idContacto == other.idContacto;
	}

	@Override
	public String toString() {
		return "Contacto2 [" + idContacto + ", " + nombre + ", " + apellidos + ", " + apodo + ", " + domicilio + "]";
	}


}
