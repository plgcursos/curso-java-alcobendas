package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Ingresando un valor entero, muestre por pantalla sus dígitos en orden inverso, por ejemplo: 
//	INGRESO: 3589, SALIDA: 9853.


public class Ej06 {
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
		System.out.println(num + " - " + inv);
	}
}
