package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Determine si un valor entero ingresado por teclado es un palíndromo (capicúa).

public class Ej07 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		System.out.println("DÍGITOS");
		
		System.out.print("Ingrese valor entero: ");
		int num = tec.nextInt();
		int aux = num;
		int inv = 0;
		
		while (aux > 0) {
			inv = inv * 10 + aux % 10;
			aux = aux / 10;
		}
		
		if (num == inv)
			System.out.println(num + " ES PALÍNDROMO");
		else
			System.out.println(num + " NO ES PALÍNDROMO");
	}
}
