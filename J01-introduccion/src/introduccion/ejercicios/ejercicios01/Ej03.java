// Dados la base y altura de un triángulo, calcular su área.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej03 {
	public static void main(String[] arg) {
		double base, altura, area;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("AREA DEL TRIANGULO");
		
		System.out.print("Ingrese base del triangulo: ");
		base = tec.nextDouble();
		
		System.out.print("Ingrese altura del triangulo: ");
		altura = tec.nextDouble();
		
		area = base * altura / 2;

		System.out.println("Area: " + area);
	}
}