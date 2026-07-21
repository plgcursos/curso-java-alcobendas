

public class Empleado extends Persona {
	private static final long serialVersionUID = 1L;

	private Integer nroEmpleado;
	private Categoria categoria;

	public Empleado(){
	}
	
	public Integer getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(Integer nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Empleado [" + nroEmpleado + ", " + categoria + ", " + getIdPersona() + ", " + getApellidos() + "]";
	}

}
