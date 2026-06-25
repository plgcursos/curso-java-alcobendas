package ejercicios10constructores.ej01;

public class Persona {
	public String nombre;
	public int edad;
	
	public Persona() {
		this("Sin nombre");
	}
	
	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public Persona(String nombre, int edad) {
		this(nombre);
		this.edad = edad;
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
	}
}
