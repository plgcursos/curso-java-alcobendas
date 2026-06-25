package ejercicios10constructores.ej06;

public class Coche extends Vehiculo {
	public int numeroPuertas;

	public Coche(String marca, String modelo, int numeroPuertas) {
		super(marca, modelo);
		this.numeroPuertas = numeroPuertas;
	}

	@Override
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Número de puertas: " + numeroPuertas);
	}
}
