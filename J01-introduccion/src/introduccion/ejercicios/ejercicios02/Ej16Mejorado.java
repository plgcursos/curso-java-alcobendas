package introduccion.ejercicios.ejercicios02;

import java.util.Scanner;

// Escribir un programa que pida un número entero positivo mayor que 2 y muestre si es un número primo o no.
public class Ej16Mejorado {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int num;

		System.out.println("NROS.PRIMOS");
		System.out.print("Ingrese valor entero: ");
		num = tec.nextInt();

		boolean esPrimo = true;
		if (num <= 1) esPrimo = false;
		if (num > 3) {
			if (num % 2 == 0)
				esPrimo = false;
			for (int i = 3; i <= Math.sqrt(num) && esPrimo; i += 2) {
				if (num % i == 0)
					esPrimo = false;
			}
		}

		if (esPrimo)
			System.out.println(num + " es Primo");
		else
			System.out.println(num + " no es Primo");
	}
}