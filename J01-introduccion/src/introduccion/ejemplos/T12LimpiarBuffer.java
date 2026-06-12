package introduccion.ejemplos;

import java.util.Scanner;

public class T12LimpiarBuffer {
	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingrese frase: ");
		String palabra = tec.next();

		System.out.print("Ingrese frase: ");
		String frase = tec.nextLine();

		
		System.out.println(frase);
		System.out.println(palabra);
	}
}
