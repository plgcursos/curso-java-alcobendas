// Dado el radio de una esfera, calcular su volumen. V = 4/3 pi r^3
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej04 {
	public static void main(String[] arg) {
		double radio, volumen;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("VOLUMEN DE LA ESFERA");
		
		System.out.print("Ingrese radio: ");
		radio = tec.nextDouble();
		
		volumen = 4 / 3 * Math.PI * Math.pow(radio, 3);

		System.out.println("Volumen: " + volumen);
	}
}
