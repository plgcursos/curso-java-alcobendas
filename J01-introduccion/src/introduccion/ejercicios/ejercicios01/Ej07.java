//Hacer un algoritmo que permita obtener la cantidad de segundos en un tiempo dado en 
	// horas, minutos y segundos
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej07 {
	public static void main(String[] arg) {
		int horas, minutos, segundos, totSegundos;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Conversor hh:mm:ss a segundos");
		
		System.out.print("Ingrese horas: ");
		horas = tec.nextInt();
		
		System.out.print("Ingrese minutos: ");
		minutos = tec.nextInt();
		
		System.out.print("Ingrese segundos: ");
		segundos = tec.nextInt();
		
		totSegundos = horas * 3600 + minutos * 60 + segundos;

		System.out.println(horas + ":" + minutos + ":" + segundos + " = " + totSegundos);
	}
}

