package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Modifique el programa anterior para que imprima el perímetro del cuadrado de la siguiente manera:
//	****
//	*  *
//	*  *
//	****
public class Ej03 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		System.out.println("PERÍMETRO CUADRADO");
		
		System.out.print("Ingrese lado: ");
		int lado = tec.nextInt();
		
		for (int i = 1; i <= lado; i++) {
			for (int j = 1; j <= lado; j++) {
				if (i > 1 && i < lado && j > 1 && j < lado)
					System.out.print("  ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}
}
