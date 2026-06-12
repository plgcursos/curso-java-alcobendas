//  Hacer otro programa que ingresando los mismos datos que el anterior y calcule el Capital 
	// final si no se hace ningún reintegro y la capitalización de los intereses es anual.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej17 {
	public static void main(String[] arg) {
		double c, r, i, cf;
		int t, n;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("INTERES COMPUESTO");
		
		System.out.print("Ingrese Capital Inicial: ");
		c = tec.nextDouble();
		
		System.out.print("Ingrese tasa interes (1 - 100): ");
		r = tec.nextDouble();
		r = r / 100;
		
		System.out.print("Ingrese años: ");
		t = tec.nextInt();
		
		// en el enunciado dice que es 1, pero para hacerlo mas correcto
		System.out.print("Cantidad capitalizaciones anuales: ");
		n = tec.nextInt();
		
		cf = c * Math.pow(1 + r / n, n * t);

		System.out.println("El Capital final será: " + cf);
	}
}