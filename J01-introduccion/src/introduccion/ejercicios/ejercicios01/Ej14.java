//Hacer un programa que Dado un año indicar si es bisiesto. Un año es bisiesto si es un 
	//numero divisible por 4, pero si es divisible por 100 debe ser es divisible por 400
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej14 {
	public static void main(String[] arg) {
		int anyo;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Bisiestos");
		
		System.out.print("Ingrese anyo: ");
		anyo = tec.nextInt();

		String mje = " no es";

		if (anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0)) {
			mje = " es";
		}

		System.out.print(anyo + mje + " bisiesto");
	}
}

