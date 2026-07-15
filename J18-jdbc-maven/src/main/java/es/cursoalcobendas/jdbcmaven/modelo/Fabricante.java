package es.cursoalcobendas.jdbcmaven.modelo;

import java.util.Objects;

public class Fabricante {
	private Integer idFabricante;
	private String fabricante;
	
	public Fabricante(String fabricante) {
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
