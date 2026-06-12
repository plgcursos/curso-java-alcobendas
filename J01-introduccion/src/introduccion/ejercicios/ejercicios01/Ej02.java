// Dado el radio de un círculo, calcular su perímetro y su área.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej02 {
	public static void main(String[] arg) {
		double radio, perimetro, area;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("AREA Y PERIMETRO DEL CIRCULO");
		
		System.out.print("Ingrese radio: ");
		radio = tec.nextDouble();
		
		area = Math.PI * radio * radio;  //area = Math.PI * Math.pow(radio, 2);
		perimetro = 2 * Math.PI * radio;

		System.out.println("Area: " + area);
		System.out.println("Perimetro: " + perimetro);
	}
}