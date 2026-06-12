package introduccion.ejercicios.ejercicios05;

//Simula el lanzamiento de un dado de 6 caras utilizando números aleatorios
public class Ej06 {

	public static int lanzaDado() {
		return (int)Math.ceil(Math.random() * 6);
	}
	
	public static void main(String[] args) {
		for (int i = 1; i < 50; i++) {
			System.out.println(lanzaDado());
		}
	}
}
