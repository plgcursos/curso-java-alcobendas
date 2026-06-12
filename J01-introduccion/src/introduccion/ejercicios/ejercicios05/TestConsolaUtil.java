package introduccion.ejercicios.ejercicios05;

import introduccion.util.Consola;

public class TestConsolaUtil {
	public static void main(String[] args) {
		int num = Consola.leeInt("Ingresa valor: ");
		
		System.out.println(num);
		
		String nombre = Consola.leeCadena("Ingresa tu nombre: ");
		
		System.out.println("Hola " + nombre);
	}
}
