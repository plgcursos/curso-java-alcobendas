package es.cursoalcobendas.tienda.modelo;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fabricante")
	private Integer idFabricante;
	private String fabricante;
	
	public Fabricante() {
	}

	public Fabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Fabricante(Integer idFabricante, String fabricante) {
		this.idFabricante = idFabricante;
		this.fabricante = fabricante;
	}

	public Integer getIdFabricante() {
		return idFabricante;
	}

	public void setIdFabricante(Integer idFabricante) {
		this.idFabricante = idFabricante;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idFabricante);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Fabricante other = (Fabricante) obj;
		return Objects.equals(idFabricante, other.idFabricante);
	}

	@Override
	public String toString() {
		return "Fabricante [" + idFabricante + ", " + fabricante + "]";
	}
}
