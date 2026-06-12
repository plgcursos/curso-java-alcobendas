package introduccion.ejemplos;

import java.util.Scanner;

public class T13LimpiarBuffer {
	public static void main(String[] args) {
		
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingrese valor 1: ");
		int num1 = tec.nextInt();
		tec.nextLine();

		System.out.print("Ingrese operador: ");
		String operador = tec.nextLine();

		System.out.print("Ingrese valor 2: ");
		int num2 = tec.nextInt();
		tec.nextLine();

		
	}
}
