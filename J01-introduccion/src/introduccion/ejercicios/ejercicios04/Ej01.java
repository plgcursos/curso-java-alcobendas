package introduccion.ejercicios.ejercicios04;

import java.util.Scanner;

//Calculadora de 4 operaciones. 
//	El usuario ingresa dos números y un carácter (+, -, *, / ) y el programa debe mostrar la operación y su resultado. 
//	Por ejemplo: 
//	Ingrese valor: 12.5 
//	Ingrese valor: 2 
//	Ingrese operación: - 
//	12.5 – 2 = 10.5

public class Ej01 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		
		System.out.println("CALCULADORA CUTRE!");
		double n1, n2, resu;
		String op;
		boolean error = false;
		
		System.out.print("n1: ");
		n1 = tec.nextDouble();
		tec.nextLine();
		
		System.out.print("operador(+,-,*,/): ");
		op = tec.nextLine();
		
		System.out.print("n2: ");
		n2 = tec.nextDouble();
		tec.nextLine();
		
		switch(op) {
			case "+" -> resu = n1 + n2; 
			case "-" -> resu = n1 - n2; 
			case "*" -> resu = n1 * n2; 
			case "/" -> resu = n1 / n2;
			default -> {
				error = true;
				resu = 0;
			}
		}
		
		if (!error)
			System.out.println(n1 + " " + op + " " + n2 + " = " + resu);
		else
			System.out.println("El operador es incorrecto");
	}
}
