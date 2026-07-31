package es.cursosanblas.examen.modelo;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")
public class Alumno extends Persona {
	private static final long serialVersionUID = 1L;

	private String matricula;
	
	@Column(name = "anyo_inscripcion")
	private Integer anyoInscripcion;
	
	@ManyToMany
	@JoinTable(name = "matriculados",
			   joinColumns = @JoinColumn(name = "fk_alumno"),
			   inverseJoinColumns = @JoinColumn(name = "fk_asignatura"))
	private Set<Asignatura> asignaturas = new HashSet<>();
	
	public Alumno() {}

	public Alumno(String dni, String nombre, String apellido1, String apellido2, String telefono,
			String direccion, String ciudad, String matricula, Integer anyoInscripcion) {
		super(dni, nombre, apellido1, apellido2, telefono, direccion, ciudad);
		this.matricula = matricula;
		this.anyoInscripcion = anyoInscripcion;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Integer getAnyoInscripcion() {
		return anyoInscripcion;
	}

	public void setAnyoInscripcion(Integer anyoInscripcion) {
		this.anyoInscripcion = anyoInscripcion;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	@Override
	public String toString() {
		return super.toString() + "\n(" + matricula + ", " + anyoInscripcion + ")";
	}
	
}
