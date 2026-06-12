package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Solicite al usuario un número que represente el mes e imprima su nombre.
public class Ej09 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.print("Ingrese mes: ");
		int mes = tec.nextInt();
		
		//switch expression
		String nombreMes = switch(mes) {
		case 1 -> "Enero";
		case 2 -> "Febrero";
		case 3 -> "Marzo";
		case 4 -> "Abril";
		case 5 -> "Mayo";
		case 6 -> "Junio";
		case 7 -> "Julio";
		case 8 -> "Agosto";
		case 9 -> "Septiembre";
		case 10 -> "Octubre";
		case 11 -> "Noviembre";
		case 12 -> "Diciembre";
		default -> "Incorrecto";
		};
		
		System.out.println(nombreMes);
	}
}
