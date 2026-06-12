package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escribir un programa que imprima todos los números pares entre dos números que 
	// se le pidan al usuario, incluidos los extremos si son pares
	
public class Ej08 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int cont = 1, desde, hasta;
		
		System.out.println("Pares en un rango");
		System.out.print("Ingrese rango inferior: ");
		desde = tec.nextInt();

		System.out.print("Ingrese rango superior: ");
		hasta = tec.nextInt();

		if(desde % 2 == 0)
			cont = desde;
		else
			cont = desde + 1;

		while (cont <= hasta) {
			System.out.println(cont);
			cont = cont + 2;
		}
	}
}