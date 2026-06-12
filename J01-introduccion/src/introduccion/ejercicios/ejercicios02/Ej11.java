package introduccion.ejercicios.ejercicios02;
import java.util.Scanner;

// Escribir un programa que imprima las tablas del 1 al 9
public class Ej11 {
	public static void main(String[] arg) {

		Scanner tec = new Scanner(System.in);
		int tabla = 1, mult;
		
		System.out.println("Tablas de multiplicar");
		
		while (tabla <= 9) {
			System.out.println("TABLA DEL " + tabla);
			mult = 1;
			while (mult <= 9) {
				System.out.println(tabla + " x " + mult + " = " + (tabla * mult));
				mult = mult + 1;
			}
			tabla = tabla + 1;
			System.out.println();
		}
	}
}