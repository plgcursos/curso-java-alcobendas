//Hacer un algoritmo que permita Obtener la cantidad de horas, minutos y segundos de un 
	// tiempo dado en segundos.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej08 {
	public static void main(String[] arg) {
		int horas, minutos, segundos, totSegundos;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Conversor segundos a hh:mm:ss");
		
		System.out.print("Ingrese segundos: ");
		totSegundos = tec.nextInt();
		
		horas = totSegundos / 3600;
		minutos = (totSegundos % 3600) / 60;
		segundos = totSegundos % 60;

		System.out.println(totSegundos + "s. = " + horas + ":" + minutos + ":" + segundos);
	}
}

