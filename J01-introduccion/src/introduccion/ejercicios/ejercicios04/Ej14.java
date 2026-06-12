package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Solicite al usuario una fecha e indicar los días que faltan hasta fin de año.

public class Ej14 {
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

		int mesPost = mes + 1;

		// validar fecha
		diasDelMes = switch (mes) {
		case 1, 3, 5, 7, 8, 10, 12 -> 31;
		case 4, 6, 9, 11 -> 30;
		case 2 -> 28;
		default -> 0;
		};

		if (dia >= 1 && dia <= diasDelMes) {

			dias = diasDelMes - dia;
			
			switch (mesPost) {
			case 2:
				dias += 28;
			case 3:
				dias += 31;
			case 4:
				dias += 30;
			case 5:
				dias += 31;
			case 6:
				dias += 30;
			case 7:
				dias += 31;
			case 8:
				dias += 31;
			case 9:
				dias += 30;
			case 10:
				dias += 31;
			case 11:
				dias += 30;
			case 12:
				dias += 31;
			case 0:
				break;
			}

			System.out.println("Faltan " + (dias) + " desde " + dia + "/" + mes + "/" + anyo + " hasta fin de año.");
		}else
			System.out.println("La fecha ingresada es incorrecta");
	}
}
