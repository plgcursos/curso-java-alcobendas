package es.cursoalcobendas.jpa.ej04_insertable;

import java.io.Serializable;

import es.cursoalcobendas.jpa.ej02_enum.Genero;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "persona_04")
public class Persona04 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona")
	private int idPersona;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "apodo")
	private String apodo;
	
	@Column(name = "dni")
	private String dni;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genero")
	private Genero genero;
	
	@Embedded
	@AttributeOverride(name = "tipoVia", column = @Column(name = "tipo_via"))
	@AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal"))
//	@AttributeOverrides(
//			{@AttributeOverride(name = "tipoVia", column = @Column(name = "tipo_via")),
//			 @AttributeOverride(name = "codigoPostal", column = @Column(name = "codigo_postal"))})
	private Domicilio dom;
	
	public Persona04() {}
	
	public Persona04(String nombre, String apellidos, String apodo, String dni, Genero genero) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.apodo = apodo;
		this.dni = dni;
		this.genero = genero;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Domicilio getDom() {
		return dom;
	}

	public void setDom(Domicilio dom) {
		this.dom = dom;
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
		Persona04 other = (Persona04) obj;
		return idPersona == other.idPersona;
	}

	@Override
	public String toString() {
		return "Persona (" + idPersona + ", " + nombre + ", " + apellidos + ", " + apodo + ", " + dni + ")";
	}
	

}
