package introduccion.ejercicios.ejercicios03;

import java.util.Scanner;

//Escribir un programa que pida al usuario un número, que representará una cantidad de dinero expresada en euros. 
//	A continuación, el programa le ofrecerá un menú al usuario en el que le preguntará a qué divisa quiere convertir del dinero e imprimirá la conversión. 
//	Las posibles divisas son las siguientes (se indica el tipo de cambio):
//• Dólares (1 dólar = 0,88 euros)
//• Libra Esterlina (1 Libra = 1,20 euros)
//• Yen (1 yen = 0,0077 euros).
//• Dólares Canadienses (1 dólar C. = 0,71 euros)

public class Ej05 {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.println("CONVERSOR EUROS");
		
		double euros, resu, factor;
		double dolar = 0.88, libra = 1.2, yen = 0.077, dCananda = 0.71;
		
		String moneda;
		String mDolar = "$", mLibra = "\u00a3", mYen = "\u00a5", mDCanada = "C$";
		
		boolean salir = false;
		int op;

		System.out.print("Ingrese importe en euros: ");
		euros = tec.nextDouble();
		tec.nextLine();

		do {
			System.out.println("0 - Otro importe en euros");
			System.out.println("1 - Dólar");
			System.out.println("2 - Libra Esterlina");
			System.out.println("3 - Yen");
			System.out.println("4 - Dólar Canadiense");
			System.out.println("9 - Salir");
			System.out.print(">");
			op = tec.nextInt();
			tec.nextLine();

			switch (op) {
				case 0 -> {
					System.out.print("Ingrese importe en euros: ");
					euros = tec.nextDouble();
					tec.nextLine();
					factor = 0;
					moneda = "";
				}
				case 1 -> {
					factor = dolar;
					moneda = mDolar;
				}
				case 2 -> {
					factor = libra;
					moneda = mLibra;
				}
				case 3 -> {
					factor = yen;
					moneda = mYen;
				}
				case 4 -> {
					factor = dCananda;
					moneda = mDCanada;
				}
				case 9 -> {
					salir = true;
					factor = 0;
					moneda = "";
				}
				default -> {
					factor = 0;
					moneda = "";
				}
			}
			if (factor != 0) {
				resu = Math.round(euros / factor * 100) / 100;
				System.out.println(euros + " € >>> " + resu + " " + moneda);
				tec.nextLine();
			}
			
		} while (!salir);
	}
}
