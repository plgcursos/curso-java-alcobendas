package es.cursoalcobendas.jpa.ej05_tipoacceso;

import java.io.Serializable;

import es.cursoalcobendas.jpa.ej02_enum.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "personas")
public class Persona05 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idPersona;
	private String nombre;
	private String apellidos;
	private String apodo;
	private String dni;
	private Genero genero;
	 
	public Persona05() {}
	
	public Persona05(String nombre, String apellidos, String apodo, String dni, Genero genero) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.dni = dni;
		this.genero = genero;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	@Column(name = "p_nombre")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		System.out.println("Acceso a setNombre(...)");
		this.nombre = nombre;
	}

	@Column(name = "p_apellidos")
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		System.out.println("Acceso a setApellidos(...)");
		this.apellidos = apellidos;
	}

	@Column(name = "p_apodo")
	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	@Column(name = "p_dni")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "p_sexo")
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Transient
	public String getNombreCompleto() {
		return apellidos + ", " + nombre;
	}
	
	@Override
	public int hashCode() {
		return idPersona;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona05 other = (Persona05) obj;
		return idPersona == other.idPersona;
	}

	@Override
	public String toString() {
		return "Persona (" + idPersona + ", " + nombre + ", " + apellidos + ", " + apodo + ", " + dni + ")";
	}
	

}
