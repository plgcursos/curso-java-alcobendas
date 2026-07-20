package es.cursoalcobendas.jpa.ej08_onetoone;

import java.io.Serializable;
import java.util.Objects;


public class Domicilio implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idDomicilio;
	private String tipoVia;
	private String via;
	private int numero;
	private int piso;
	private String puerta;
	private String ciudad;
	
	public Domicilio() {}

	public Domicilio(String tipoVia, String via, int numero, int piso, String puerta, String ciudad) {
		this.tipoVia = tipoVia;
		this.via = via;
		this.numero = numero;
		this.piso = piso;
		this.puerta = puerta;
		this.ciudad = ciudad;
	}

	public int getIdDomicilio() {
		return idDomicilio;
	}

	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getPuerta() {
		return puerta;
	}

	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDomicilio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domicilio other = (Domicilio) obj;
		return idDomicilio == other.idDomicilio;
	}

	@Override
	public String toString() {
		return "Domicilio [" + idDomicilio + ", " + tipoVia + ", " + via + ", " + numero + ", " + piso + ", " + puerta
				+ ", " + ciudad + "]";
	}

}
