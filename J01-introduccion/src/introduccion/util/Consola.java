package introduccion.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {

	public static Scanner tec = new Scanner(System.in);
	
	public static String leeCadena(String mensaje) {
		System.out.print(mensaje);
		return tec.nextLine();
	}
	
	public static String leeCadena() {
		return leeCadena("");
	}
	
	public static int leeInt(String mensaje) {
		boolean ok;
		int n;
		do {
			ok = true;
			System.out.print(mensaje);
			try {
				n = tec.nextInt();
				tec.nextLine();
			} catch(InputMismatchException e) {
				System.out.println("Ingrese un valor entero!!!");
				ok = false;
				n = 0;
				tec.nextLine();
			}
		} while(!ok);
		return n;
	}
	
	public static int leeInt() {
		return leeInt("");
	}
	
	public static void muestraTitulo(String titulo) {
		System.out.println(titulo);
		System.out.println("-".repeat(titulo.length()));
	}

}
