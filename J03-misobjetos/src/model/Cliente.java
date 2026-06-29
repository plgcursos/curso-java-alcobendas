package model;

import java.util.Objects;

public class Cliente {

	private Integer idCliente;
	private String nombre;
	private String apellidos;
	private Double saldo;
	
	public Cliente() {
	}

	public Cliente(Integer idCliente, String nombre, String apellidos) {
		this(idCliente, nombre, apellidos, 0.0);
	}

	public Cliente(Integer idCliente, String nombre, String apellidos, Double saldo) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.saldo = saldo;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Cliente [" + idCliente + ", " + nombre + ", " + apellidos + ", " + saldo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}
	

}
