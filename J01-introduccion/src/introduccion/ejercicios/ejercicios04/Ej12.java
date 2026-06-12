package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Solicite al usuario una fecha e indicar los días que faltan hasta fin de mes.

public class Ej12 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingrese dia: ");
		int dia = tec.nextInt();
		System.out.print("Ingrese mes: ");
		int mes = tec.nextInt();
		System.out.print("Ingrese año: ");
		int anyo = tec.nextInt();
		int dias;
		
		dias = switch(mes) {
		case 1, 3, 5, 7, 8, 10, 12 -> 31;
		case 4, 6, 9, 11 -> 30;
		case 2 -> 28;
		default -> 0;
		};
		
		if (dia >= 1 && dia <= dias)
			System.out.println(dia + "/" + mes + "/" + anyo + " quedan " + (dias-dia) + " días hasta fin de mes.");
		else
			System.out.println("La fecha ingresada es incorrecta");
	}
}
