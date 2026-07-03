package sets;

import java.util.Comparator;
import java.util.Objects;

public class Cliente implements Comparable<Cliente> {
	private int idCliente;
	private String nombre;
	private String telefono;
	
	public Cliente() {
	}

	public Cliente(int idCliente, String nombre) {
		this.idCliente = idCliente;
		this.nombre = nombre;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [" + idCliente + ", " + (nombre != null ? nombre : "")
				+ (telefono != null ? ", " + telefono : "") + "]";
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
		return idCliente == other.idCliente;
	}

	@Override
	public int compareTo(Cliente o) {
		return this.idCliente - o.idCliente;
	}
	
	public static Comparator<Cliente> getNombreComparator(){
		return new Comparator<Cliente>() {
			@Override
			public int compare(Cliente c1, Cliente c2) {
				return c1.getNombre().compareToIgnoreCase(c2.getNombre());
			}
		};
	}
}
