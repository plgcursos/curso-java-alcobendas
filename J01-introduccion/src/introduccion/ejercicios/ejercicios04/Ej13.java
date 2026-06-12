package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Solicite al usuario una fecha e indicar la cantidad de días transcurridos en ese año hasta esa fecha.

public class Ej13 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingrese dia: ");
		int dia = tec.nextInt();
		System.out.print("Ingrese mes: ");
		int mes = tec.nextInt();
		System.out.print("Ingrese año: ");
		int anyo = tec.nextInt();
		int dias = 0;
		int diasDelMes;
		
		int mesAnt = mes - 1;
		
		//validar fecha
		diasDelMes = switch(mes) {
		case 1, 3, 5, 7, 8, 10, 12 -> 31;
		case 4, 6, 9, 11 -> 30;
		case 2 -> 28;
		default -> 0;
		};
		
		
		switch(mesAnt) {
		case 11:
			dias += 30;
		case 10:
			dias += 31;
		case 9:
			dias += 30;
		case 8:
			dias += 31;
		case 7:
			dias += 31;
		case 6:
			dias += 30;
		case 5:
			dias += 31;
		case 4:
			dias += 30;
		case 3:
			dias += 31;
		case 2:
			dias += 28;
		case 1:
			dias += 31;
		case 0:
			break;
		}
		
		if (dia >= 1 && dia <= diasDelMes)
			System.out.println("Has transcurrido " + (dia + dias - 1) + " días del año al " + dia + "/" + mes + "/" + anyo);
		else
			System.out.println("La fecha ingresada es incorrecta");
	}
}
