

import java.util.Set;

public class Cliente extends Persona {
	private static final long serialVersionUID = 1L;

	private Integer nroCliente;
	private String categoria;
	private Set<Producto> productos;
	
	public Cliente(){
	}

	public Integer getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(Integer nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Cliente [" + nroCliente + ", " + categoria + ", " + getIdPersona() + ", "
				+ getApellidos() + "]";
	}

}
