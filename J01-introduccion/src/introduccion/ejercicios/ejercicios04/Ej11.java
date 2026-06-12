package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Solicitar una fecha (día, mes, año) y validar si es una fecha correcta sin contemplar años bisiestos, es decir, 
//  no se puede ingresar 29 2 xxxx.

public class Ej11 {
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
			System.out.println(dia + "/" + mes + "/" + anyo + " es correcta");
		else
			System.out.println("La fecha ingresada es incorrecta");
	}
}
