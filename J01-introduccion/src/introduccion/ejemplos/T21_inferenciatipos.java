package introduccion.ejemplos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class T21_inferenciatipos {
	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<>();
		
		//Un literal entero es de tipo int
		// Automaticamente lo transforma a byte o short si se asigna a una valiable de esos tipos
		int num = 55;
		short s = 55;
		byte b = 55;
		long l = 3_000_000_000L;// El int mayor es 2_147_483_647, luego 3_000_000_000 no es un int válido, debemos
								// usar el sufijo L
		System.out.println(Integer.MAX_VALUE);
		
		//Los literales reales son siempre "double"
		double d = 1.5;
		float f = 1.5F; // Para dar valor a un float, debemos usar el sufijo F
	
		var otro = 10; // int otro = 10;
		var otroMas = 10L;
		var real = 1.5;
		
		var algo = "hola";
		
		var lista = new LinkedList<Integer>(); // LinkedList<Integer> lista = new...
		var teclado = new Scanner(System.in);
	}
}
