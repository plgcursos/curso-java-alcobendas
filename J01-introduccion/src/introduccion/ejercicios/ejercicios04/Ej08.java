package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Escriba un programa que imprima los siguientes patrones por separado, uno debajo del siguiente, una vez que el usuario ingresó el tamaño,
//	por ejemplo 5. Utilice ciclos for para generar los patrones. 
//	Todos los asteriscos deberán ser impresos por un solo enunciado print de la forma print(‘*’). 
//	Sugerencia: los dos últimos patrones requieren que cada línea comience con un número correcto de espacios en blanco: print(‘ ’).
//	*      *****  *****      *
//	**     ****    ****     **
//	***    ***      ***    ***
//	****   **        **   ****
//	*****  *          *  *****
public class Ej08 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);

		System.out.println("TRIANGULOS");
		
		System.out.print("Ingrese lado: ");
		int lado = tec.nextInt();
		
		for (int i = 1; i <= lado; i++) {
			for (int j = 1; j <= i; j++) {
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i <= lado; i++) {
			for (int j = 1; j <= lado - i + 1; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i <= lado; i++) {
			for (int j = 1; j <= lado; j++) {
				if (j < i)
					System.out.print("  ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i <= lado; i++) {
			for (int j = 1; j <= lado; j++) {
				if (j < lado - i + 1)
					System.out.print("  ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("======================");
		//Otra forma de resolver los dos últimos
		
		for (int i = 1; i <= lado; i++) {
			for (int j = 1; j <= i -1; j++) 
					System.out.print("  ");

			for (int j = i; j <= lado; j++) 
					System.out.print("* ");
			
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i <= lado; i++) {
			for (int j = i; j <= lado - 1; j++) 
				System.out.print("  ");
			
			for (int j = 1; j <= i; j++) 
				System.out.print("* ");
			
			System.out.println();
		}
		System.out.println();
	}
}
