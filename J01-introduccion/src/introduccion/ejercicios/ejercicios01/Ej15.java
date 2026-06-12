//  Hacer un algoritmo que, dados los catetos de un triángulo rectángulo, calcule su 
	// hipotenusa
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej15 {
	public static void main(String[] arg) {
		double a, b, h;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("PITAGORAS");
		
		System.out.print("Ingrese cateto 1: ");
		a = tec.nextDouble();
		
		System.out.print("Ingrese cateto 2: ");
		b = tec.nextDouble();
		
		h = Math.sqrt(a * a + b * b);

		System.out.println("Hipotenusa: " + h);
	}
}