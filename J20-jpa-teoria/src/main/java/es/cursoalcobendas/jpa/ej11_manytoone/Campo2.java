package es.cursoalcobendas.jpa.ej11_manytoone;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "campos")
public class Campo2 implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcampo")
	private Integer idCampo;
	private String campo;
	private String direccion;
	
	@OneToMany(mappedBy = "campo")
	private Set<Partido2> partidos = new HashSet<>();
	
	public Campo2() {
	}

	public Campo2(String campo, String direccion) {
		this.campo = campo;
		this.direccion = direccion;
	}

	public Integer getIdCampo() {
		return idCampo;
	}

	public void setIdCampo(Integer idCampo) {
		this.idCampo = idCampo;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Partido2> getPartidos() {
		return partidos;
	}

	public void setPartidos(Set<Partido2> partidos) {
		this.partidos = partidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCampo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campo2 other = (Campo2) obj;
		return Objects.equals(idCampo, other.idCampo);
	}

	@Override
	public String toString() {
		return "Campo2 [" + idCampo + ", " + campo + ", " + direccion + "]";
	}

	

}
