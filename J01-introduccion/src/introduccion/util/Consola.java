package introduccion.util;

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
		System.out.print(mensaje);
		int n = tec.nextInt();
		tec.nextLine();
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
