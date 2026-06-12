package introduccion.ejercicios.ejercicios05;

//Escribe un método que retorne la suma de los dígitos de un número entero 
//	(ejemplo: 1234 -> 1+2+3+4 = 10).

public class Ej03 {
	
	public static int sumaDigitos(int num) {
		int suma = 0;
		num = Math.abs(num);
		while (num != 0) {
			suma += num % 10;
			num /= 10;
		}
		return suma;
	}
	
	public static void main(String[] args) {
		System.out.println(sumaDigitos(123456));
		System.out.println(sumaDigitos(3));
		System.out.println(sumaDigitos(3000));
		System.out.println(sumaDigitos(-45));
	}
}
