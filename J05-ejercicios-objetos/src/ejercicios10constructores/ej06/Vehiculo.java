package ejercicios10constructores.ej06;

public class Vehiculo {

	public String marca;
	public String modelo;
	
	public Vehiculo(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public void mostrarDatos() {
		System.out.println("Marca: " + marca + ", Modelo: " + modelo);
	}
}
