package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Solicite al usuario un número que represente el mes e imprima su nombre.
public class Ej10 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingrese mes: ");
		int mes = tec.nextInt();
		int dias;
		
		//switch expression
		String nombreMes = switch(mes) {
			case 1 -> {
				dias = 28;
				yield "Enero";
			}
			case 2 -> {
				dias = 31;
				yield "Febrero";
			}
			case 3 -> {
				dias = 31;
				yield "Marzo";
			}
			case 4 -> {
				dias = 30;
				yield "Abril";
			}
			case 5 -> {
				dias = 31;
				yield "Mayo";
			}
			case 6 -> {
				dias = 30;
				yield "Junio";
			}
			case 7 -> {
				dias = 31;
				yield "Julio";
			}
			case 8 -> {
				dias = 31;
				yield "Agosto";
			}
			case 9 -> {
				dias = 30;
				yield "Septiembre";
			}
			case 10 -> {
				dias = 31;
				yield "Octubre";
			}
			case 11 -> {
				dias = 30;
				yield "Noviembre";
			}
			case 12 -> {
				dias = 31;
				yield "Diciembre";
			}
			default -> {
				dias = 0;
				yield "Incorrecto";
			}
		};
		if (dias != 0)
			System.out.println("El mes " + nombreMes + " tiene " + dias + " dias.");
		else
			System.out.println("El mes ingresado es incorrecto");
	}
}
