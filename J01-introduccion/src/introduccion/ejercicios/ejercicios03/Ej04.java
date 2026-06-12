package introduccion.ejercicios.ejercicios03;

import java.util.Scanner;

//Realizar un programa que adivine el número (entre 0 y 100) que ha pensado el usuario. En 
//	cada paso, el programa propone un número y el usuario debe contestar, introduciendo su 
//	contestación como dato, si ha acertado, o bien si el número que ha propuesto el 
//	ordenador es mayor o es menor que el que tenía pensado. Por ejemplo, ingresando:
//	0 –> Acierto
//	1 –> El valor propuesto es mayor
//	-1 –> El valor propuesto es Menor
public class Ej04 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.println("ORDENADOR ADIVINA EL NÚMERO");
		System.out.println("0 –> Acierto");
		System.out.println("1 –> El valor propuesto es mayor");
		System.out.println("-1 –> El valor propuesto es Menor");
		int min = 0;
		int max = 100;
		int intento;
		int opcion;
		boolean adivino = false;
		
		while (!adivino) {
			intento = (min + max) / 2;
			System.out.print("Es el " + intento + "? ");
			opcion = tec.nextInt();

			switch(opcion) {
			case 0 -> adivino = true;
			case 1 -> max = intento;
			case -1 -> min = intento;
			}
		}
		System.out.println("Enhorabuena!!! has acertado");
	}
}
