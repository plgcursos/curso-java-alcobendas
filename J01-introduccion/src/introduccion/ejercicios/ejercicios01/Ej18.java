// Escribir un programa que dados dos puntos en el plano A(x1, x2) y B(x2, y2), imprima la 
	//distancia entre ambos.
	// d(A,B) = raiz((x2-x2)^2 + (y2-y1)^2)
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej18 {
	public static void main(String[] arg) {
		double x1, y1, x2, y2, d;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("DISTANCIA ENTRE DOS PUNTOS");
		
		System.out.println("Ingrese coordenadas A: ");
		System.out.print("x: ");
		x1 = tec.nextDouble();
		System.out.print("y: ");
		y1 = tec.nextDouble();
		
		System.out.println("Ingrese coordenadas B: ");
		System.out.print("x: ");
		x2 = tec.nextDouble();
		System.out.print("y: ");
		y2 = tec.nextDouble();
		
		d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
		
		System.out.println("A(" + x1 + ", " + y1 + ")");
		System.out.println("B(" + x2 + ", " + y2 + ")");
		System.out.println("d(A, B) = " + d);
		
	}
}