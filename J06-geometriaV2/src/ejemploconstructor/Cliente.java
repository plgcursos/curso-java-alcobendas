package ejemploconstructor;

public class Cliente {
	String nombre;
	String apellido;
	double saldo;
	int edad;
	String domicilio;
	
	public Cliente(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Cliente(String nombre, String apellido) {
		this(nombre);
		this.apellido = apellido;
	}
	
	public Cliente(String nombre, String apellido, double saldo) {
		this(nombre, apellido);
		this.saldo = saldo;
	}
	
	public Cliente(String nombre, String apellido, double saldo, int edad) {
		this(nombre, apellido, saldo);
		this.edad = edad;
	}
	
	
}
