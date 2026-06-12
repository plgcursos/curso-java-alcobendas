//Dados tres números, indicar el mayor y el menor valor de los tres.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej11 {
	public static void main(String[] arg) {
		int num1, num2, num3, mayor, menor;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Mayor y menor de tres");
		
		System.out.print("Ingrese nro: ");
		num1 = tec.nextInt();
		
		System.out.print("Ingrese nro: ");
		num2 = tec.nextInt();

		System.out.print("Ingrese nro: ");
		num3 = tec.nextInt();

		if (num1 >= num2 && num1 >= num3) {
			mayor = num1;
		} else if (num2 >= num3) {
			mayor = num2;
		} else {
			mayor = num3;
		}
		
		if (num1 <= num2 && num1 <= num3) {
			menor = num1;
		} else if (num2 <= num3) {
			menor = num2;
		} else {
			menor = num3;
		}
		
		System.out.println("Mayor: " + mayor);
		System.out.println("Menor: " + menor);
	}
}

