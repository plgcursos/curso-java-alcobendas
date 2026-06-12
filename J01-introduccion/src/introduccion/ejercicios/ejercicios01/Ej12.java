//Escribir un programa que lea de teclado dos tiempos expresados en horas, minutos y 
	//segundos; las sume y muestre el resultado en horas, minutos y segundos por pantalla.
package introduccion.ejercicios.ejercicios01;

import java.util.Scanner;

public class Ej12 {
	public static void main(String[] arg) {
		int horas, minutos, segundos, totSegundos;
		int horas1, minutos1, segundos1, totSegundos1;
		int horas2, minutos2, segundos2, totSegundos2;
		
		Scanner tec = new Scanner(System.in);
				
		System.out.println("Suma tiempos");
		
		System.out.print("Ingrese horas: ");
		horas1 = tec.nextInt();
		System.out.print("Ingrese minutos: ");
		minutos1 = tec.nextInt();
		System.out.print("Ingrese segundos: ");
		segundos1 = tec.nextInt();
		
		totSegundos1 = horas1 * 3600 + minutos1 * 60 + segundos1;

		System.out.print("Ingrese horas: ");
		horas2 = tec.nextInt();
		System.out.print("Ingrese minutos: ");
		minutos2 = tec.nextInt();
		System.out.print("Ingrese segundos: ");
		segundos2 = tec.nextInt();
		
		totSegundos2 = horas2 * 3600 + minutos2 * 60 + segundos2;
		
		totSegundos = totSegundos1 + totSegundos2;
		
		horas = totSegundos / 3600;
		minutos = (totSegundos % 3600) / 60;
		segundos = totSegundos % 60;

		System.out.print(horas1 + ":" + minutos1 + ":" + segundos1);
		System.out.print(" + " + horas2 + ":" + minutos2 + ":" + segundos2);
		System.out.println(" = " + horas + ":" + minutos + ":" + segundos);
	}
}

