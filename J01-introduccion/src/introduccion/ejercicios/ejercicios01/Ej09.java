//Dados dos números, indicar el mayor y el menor valor de los dos.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej09 {
	public static void main(String[] arg) {
		int num1, num2, mayor, menor;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Mayor y menor de dos");
		
		System.out.print("Ingrese primer nro: ");
		num1 = tec.nextInt();
		
		System.out.print("Ingrese segundo nro: ");
		num2 = tec.nextInt();

		if (num1 >= num2) {
			mayor = num1;
			menor = num2;
		} else {
			mayor = num2;
			menor = num1;
		}

		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
	}
}

