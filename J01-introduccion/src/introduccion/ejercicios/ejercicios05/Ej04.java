package introduccion.ejercicios.ejercicios05;

//Crea un método que determine si un número es "perfecto", es decir, si la suma de sus 
//divisores propios es igual al número mismo. Los divisores propios de un número son los 
//divisores positivos menores que él (sin incluir al número), por ejemplo, los divisores propios 
//de 6 son: 1, 2 y 3. Además la suma de los divisores propios de 6 es igual a 6, entonces 6 es un 
//número perfecto. (1 + 2 + 3 = 6). 
//Números perfectos para probar: 6, 28, 496, 8_128, 33_550_336.
public class Ej04 {

	public static int sumaDivisoresPropios(int num) {
		int sum = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0)
				sum += i;
		}
		return sum;
	}
	
	public static boolean esPerfecto(int num) {
		return num == sumaDivisoresPropios(num);
	}
	
	public static void muestraEsPerfecto (int num) {
		System.out.println(num + (esPerfecto(num) ? " es " : " no es") + "perfecto");
	}
	
	public static void main(String[] args) {
		System.out.println(sumaDivisoresPropios(6));
		
		muestraEsPerfecto(6);
		muestraEsPerfecto(28);
		muestraEsPerfecto(496);
		muestraEsPerfecto(8_128);
		muestraEsPerfecto(33_550_336);
	}
}
