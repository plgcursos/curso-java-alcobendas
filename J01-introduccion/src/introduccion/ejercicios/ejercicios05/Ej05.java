package introduccion.ejercicios.ejercicios05;

//Dos números son "amigables" si la suma de los divisores propios de uno es igual al otro. Por 
//ejemplo, los divisores propios de 8 son: 1, 2 y 4 y la suma de éstos 1 + 2 + 4 = 7; luego 8 es un 
//número amigo de 7. Escribe un método que determine si dos números dados son amigables.
public class Ej05 {

	public static boolean sonAmigables(int num1, int num2) {
		return Ej04.sumaDivisoresPropios(num1) == num2;
	}
	
	public static void main(String[] args) {
		System.out.println(sonAmigables(8, 7));
		System.out.println(sonAmigables(7, 8));
	}
}
