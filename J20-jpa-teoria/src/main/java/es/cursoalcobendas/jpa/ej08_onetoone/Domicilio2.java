package es.cursoalcobendas.jpa.ej08_onetoone;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio2 implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddomicilio")
	private int idDomicilio;
	@Column(name = "tipovia")
	private String tipoVia;
	private String via;
	private int numero;
	private int piso;
	private String puerta;
	private String ciudad;
	
	@OneToOne(mappedBy = "domicilio")
	private Contacto2 contacto;
	
	public Domicilio2() {}

	public Domicilio2(String tipoVia, String via, int numero, int piso, String puerta, String ciudad) {
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

	public Contacto2 getContacto() {
		return contacto;
	}

	public void setContacto(Contacto2 contacto) {
		this.contacto = contacto;
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
		Domicilio2 other = (Domicilio2) obj;
		return idDomicilio == other.idDomicilio;
	}

	@Override
	public String toString() {
		return "Domicilio2 [" + idDomicilio + ", " + tipoVia + ", " + via + ", " + numero + ", " + piso + ", " + puerta
				+ ", " + ciudad + "]";
	}


}
