package enumerated;

public class Jugador {
	private String nombre;
	private PuestoRugby puesto;

	public Jugador(String nombre, PuestoRugby puesto) {
		this.nombre = nombre;
		this.puesto = puesto;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public PuestoRugby getPuesto() {
		return puesto;
	}
	
	public void setPuesto(PuestoRugby puesto) {
		this.puesto = puesto;
	}
	
}
