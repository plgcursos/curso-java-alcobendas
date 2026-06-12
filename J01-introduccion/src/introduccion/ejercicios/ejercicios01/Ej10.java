//Dado un número cualquier por teclado, mostrar su valor absoluto.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej10 {
	public static void main(String[] arg) {
		double num, abs;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Valor absoluto");
		
		System.out.print("Ingrese valor: ");
		num = tec.nextDouble();
				
		if (num >= 0) {
			abs = num;
		} else {
			abs = -num;
		}

		System.out.println("|" + num + "| = " + abs);
	}
}

