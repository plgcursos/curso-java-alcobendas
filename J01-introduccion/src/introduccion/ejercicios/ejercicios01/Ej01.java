// Dados los lados de un rectángulo, calcular su perímetro y su área.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej01 {
	public static void main(String[] arg) {
		double lado1, lado2, perimetro, area;
		
		@SuppressWarnings("resource")
		Scanner tec = new Scanner(System.in);
				
		System.out.println("AREA Y PERIMETRO DEL RECTANGULO");
		
		System.out.print("Ingrese lado 1: ");
		lado1 = tec.nextDouble();
		
		System.out.print("Ingrese lado 2: ");
		lado2 = tec.nextDouble();
		
		area = lado1 * lado2;
		perimetro = 2 * (lado1 + lado2);

		System.out.println("Area: " + area);
		System.out.println("Perimetro: " + perimetro);
	}
}