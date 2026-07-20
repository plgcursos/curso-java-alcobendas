package es.cursoalcobendas.jpa.ej09_elementcollection;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto3 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContacto;
	private String nombre;
	private String apellidos;
	private String apodo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iddomicilio")
	private Domicilio3 domicilio;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "telefonos", joinColumns = @JoinColumn(name = "idcontacto"))
	@Column(name = "telefono")
	private Set<String> telefonos = new LinkedHashSet<>();
	
	public Contacto3() {}

	public Contacto3(String nombre, String apellidos, String apodo, Domicilio3 domicilio) {
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


	public Domicilio3 getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio3 domicilio) {
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

	public Set<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<String> telefonos) {
		this.telefonos = telefonos;
	}

	public void addTelefono(String telefono) {
		telefonos.add(telefono);
	}
	
	public void addTelefonos(String... telefonos) {
		for (String telefono : telefonos) {
			this.telefonos.add(telefono);
		}
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
		Contacto3 other = (Contacto3) obj;
		return idContacto == other.idContacto;
	}

	@Override
	public String toString() {
		return "Contacto [" + idContacto + ", " + nombre + ", " + apellidos + ", " + apodo + ", " + domicilio + "]";
	}

}
