package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Ingresando un número entero por teclado de 4 cifras, mostrar sus dígitos uno por línea.
public class Ej04 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		System.out.println("DÍGITOS");
		
		System.out.print("Ingrese valor entero: ");
		int num = tec.nextInt();
		int aux = num;
		
		for (int i = 1; i <= 4; i++) {
			System.out.println(aux % 10);
			aux = aux / 10;
		}
	}
}
