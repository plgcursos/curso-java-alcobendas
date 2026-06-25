package ejercicios10constructores.ej09;

public class Persona {
	public String nombre;

	public Persona(String nombre) {
		this.nombre = nombre;
	}
}

class Alumno extends Persona {
	public String curso;

	public Alumno(String nombre, String curso) {
		super(nombre);
		this.curso = curso;
	}
}
