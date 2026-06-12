//Hacer un programa que dado un número entero n, indica si es o no par.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej13 {
	public static void main(String[] arg) {
		int num;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Par/Impar");
		
		System.out.print("Ingrese num: ");
		num = tec.nextInt();

		String mje = "par";

		if (num % 2 != 0) {
			mje = "impar";
		}

		System.out.print(num + " es " + mje);
	}
}

