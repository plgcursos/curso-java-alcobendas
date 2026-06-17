package strings.ejercicios;

//1. Pedir al usuario una cadena y decir si empieza por el carácter ‘H’.
//2. Como el anterior, pero sin importar si es mayúscula o minúscula.
public class Ej01Y02 {
	
	public static boolean comienzaConH(String s) {
		return s.startsWith("H");
	}
	
	public static boolean comienzaConHoh(String s) {
		return s.startsWith("h") || s.startsWith("H");
	}
}
