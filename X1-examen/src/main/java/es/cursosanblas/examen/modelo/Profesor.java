package es.cursosanblas.examen.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor extends Persona {
	private static final long serialVersionUID = 1L;

	@Column(name = "nro_seg_social")
	private String nroSeguridadSocial;
	
	public Profesor() {}

	public Profesor(String dni, String nombre, String apellido1, String apellido2, String telefono,
			String direccion, String ciudad, String nroSeguridadSocial) {
		super(dni, nombre, apellido1, apellido2, telefono, direccion, ciudad);
		this.nroSeguridadSocial = nroSeguridadSocial;
	}

	public String getNroSeguridadSocial() {
		return nroSeguridadSocial;
	}

	public void setNroSeguridadSocial(String nroSeguridadSocial) {
		this.nroSeguridadSocial = nroSeguridadSocial;
	}

}
