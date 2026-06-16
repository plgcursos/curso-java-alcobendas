package strings.ejercicios;

//Desarrollar un método que reciba una cadena y retorne otra con la original invertida.
public class Ej08 {
	
	public static String invierte(String s) {
		String inv = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			inv += s.charAt(i);
		}
		return inv;
	}
	
	public static String invierte2(String s) {
		String inv = "";
		for (int i = 0; i < s.length(); i++) {
			inv = s.charAt(i) + inv;
		}
		return inv;
	}
	
	public static void main(String[] args) {
		System.out.println(invierte("Hola"));
		System.out.println(invierte2("Hola"));
	}
}
