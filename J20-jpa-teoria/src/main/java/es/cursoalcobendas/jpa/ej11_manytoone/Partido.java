package es.cursoalcobendas.jpa.ej11_manytoone;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "partidos")
public class Partido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpartido")
	private Integer idPartido;
	private String partido;
	
	@ManyToOne
	@JoinColumn(name = "idcampo")
	private Campo campo;

	public Partido() {
	}

	public Partido(String partido, Campo campo) {
		this.partido = partido;
		this.campo = campo;
	}

	public Integer getIdPartido() {
		return idPartido;
	}

	public void setIdPartido(Integer idPartido) {
		this.idPartido = idPartido;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public Campo getCampo() {
		return campo;
	}

	public void setCampo(Campo campo) {
		this.campo = campo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPartido);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(idPartido, other.idPartido);
	}

	@Override
	public String toString() {
		return "Partido [" + idPartido + ", " + partido + ", " + campo + "]";
	}

}
