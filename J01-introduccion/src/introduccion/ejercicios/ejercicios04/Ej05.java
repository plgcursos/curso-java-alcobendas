package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Repetir el ejercicio anterior, pero ingresando un número entero de cualquier cantidad de cifras.
public class Ej05 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		System.out.println("DÍGITOS");
		
		System.out.print("Ingrese valor entero: ");
		int num = tec.nextInt();
		int aux = num;
		
		while (aux > 0) {
			System.out.println(aux % 10);
			aux = aux / 10;
		}
	}
}
