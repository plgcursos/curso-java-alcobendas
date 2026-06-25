package ejercicios10constructores.ej01;

public class TestEj02 {
	public static void main(String[] args) {
		Persona p1 = new Persona();
		Persona p2 = new Persona("Carlos");
		Persona p3 = new Persona("Lucía", 30);
		
		p1.mostrarDatos();
		p2.mostrarDatos();
		p3.mostrarDatos();
	}
}
