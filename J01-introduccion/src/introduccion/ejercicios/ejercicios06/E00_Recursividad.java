package introduccion.ejercicios.ejercicios06;

import introduccion.util.Consola;

public class E00_Recursividad {
	
	//Sumatorio de los nros naturales hasta n
	public static int suma(int n) {
		if (n == 1)
			return 1;
		
		return n + suma(n - 1);
	}
	
	public static void main(String[] args) {
		Consola.muestraTitulo("TEORIA DE METODOS RECURSIVOS");
		System.out.println(cantDigitos(14895));
		System.out.println(cantDigitosIt(14895));
		
		System.out.println(sumaDigitos(14895));
		System.out.println(sumaDigitosIt(14895));
		
	}
	
	// Cuenta la cantidad de digitos de n
	public static int cantDigitos(int n) {
		if (n <= 9)
			return 1;
		return 1 + cantDigitos(n / 10);
	}
	
	public static int cantDigitosIt(int n) {
		int cont = 0;
		while (n > 0) {
			cont++;
			n /= 10; // n = n / 10;
		}
		return cont;
	}
	
	
	
	// Suma los digitos de n
	public static int sumaDigitos(int n) {
		if (n <= 9)
			return n;
		return n % 10 + sumaDigitos(n / 10);
	}
	
	public static int sumaDigitosIt(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10; // sum = sum + n % 10;
			n /= 10; // n = n / 10;
		}
		return sum;
	}
}





