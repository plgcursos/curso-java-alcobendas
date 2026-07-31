package es.cursoalcobendas.recuperacion.modelo;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarjetas")
public class Tarjeta implements Serializable, Comparable<Tarjeta> {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tarjeta")
	private Integer idTarjeta;
	private String pan;
	private String marca;
	private String tipo;
	
	@Column(name = "anyo_vencimiento")
	private int anyoVencimiento;
	
	@Column(name = "mes_vencimiento")
	private int mesVencimiento;

	@ManyToOne
	@JoinColumn(name = "fk_cuenta")
	private Cuenta cuenta;

	@OneToMany(mappedBy = "tarjeta")
	private Set<Movimiento> movimientos;
	
	public Integer getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAnyoVencimiento() {
		return anyoVencimiento;
	}

	public void setAnyoVencimiento(int anyoVencimiento) {
		this.anyoVencimiento = anyoVencimiento;
	}

	public int getMesVencimiento() {
		return mesVencimiento;
	}

	public void setMesVencimiento(int mesVencimiento) {
		this.mesVencimiento = mesVencimiento;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Set<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(Set<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTarjeta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return Objects.equals(idTarjeta, other.idTarjeta);
	}

	@Override
	public int compareTo(Tarjeta o) {
		return this.idTarjeta.compareTo(o.idTarjeta);
	}

	public static Comparator<Tarjeta> getComparatorPan(){
		return (t1, t2) -> t1.pan.compareTo(t2.pan);
	}
}
