package es.cursoalcobendas.jpa.ej12_manytomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores_03")
public class Jugador implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idjugador")
	private Integer idJugador;
	
	@Column(name = "nombreyapellidos")
	private String nombre;
	
	private String dorsal;
	private String licencia;

	@ManyToMany
	@JoinTable(
			name = "equipos_jugadores_03", 
			joinColumns = @JoinColumn(name = "idjugador"), 
			inverseJoinColumns = @JoinColumn(name = "idequipo")
	)
	private Set<Equipo> equipos = new HashSet<>();

	public Jugador() {
	}

	public Jugador(String nombre, String dorsal, String licencia, Set<Equipo> equipos) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.licencia = licencia;
		this.equipos = equipos;
	}

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public Set<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idJugador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(idJugador, other.idJugador);
	}

	@Override
	public String toString() {
		return "Jugador [" + idJugador + ", " + nombre + ", " + dorsal + ", " + licencia + "]";
	}

}
