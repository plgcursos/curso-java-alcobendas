package introduccion.ejercicios.ejercicios03;

import java.util.Random;
import java.util.Scanner;
//El programa generará un número aleatorio entre 0 y 100 y le pedirá al usuario que lo 
//	adivine. Cuando el usuario ingrese el número para ver si acertó, el programa le indicará si 
//	el número a adivinar es mayor, menor o bien si acertó. Cuando acierte, finaliza.
public class Ej03 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("ADIVINA EL NÚMERO");
				
		int num = rand.nextInt(1, 101), intento;
		boolean adivino = false;
		
		while (!adivino) {
			System.out.print("Cúal es mi número?: ");
			intento = tec.nextInt();
			
			if (intento == num)
				adivino = true;
			else if(intento < num)
				System.out.println("El " + intento + " es menor a mi número");
			else
				System.out.println("El " + intento + " es mayor a mi número");
		}
		System.out.println("Enhorabuena!!! has acertado");
	}
}
