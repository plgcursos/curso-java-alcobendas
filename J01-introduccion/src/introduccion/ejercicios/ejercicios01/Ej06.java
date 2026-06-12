// Escribir un programa que convierta un valor dado en grados Fahrenheit a grados Celsius. 
	// Fórmula para la conversión: F = 9/5C + 32
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej06 {
	public static void main(String[] arg) {
		double f, celsius;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Conversor Fahrenheit a Celsius");
		
		System.out.print("Ingrese grados Fahrenheit: ");
		f = tec.nextDouble();
		
		celsius = 5. / 9. * (f - 32);

		System.out.println(f + " ºF = " + celsius + " ºC");
	}
}
