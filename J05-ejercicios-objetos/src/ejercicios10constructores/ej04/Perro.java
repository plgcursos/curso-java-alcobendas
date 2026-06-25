package ejercicios10constructores.ej04;

public class Perro extends Animal {
	public String raza;

	public Perro(String nombre, int edad, String raza) {
		super(nombre, edad);
		this.raza = raza;
	}
	
	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Raza: " + raza);
	}
}
