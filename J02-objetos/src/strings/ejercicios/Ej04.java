package strings.ejercicios;

//Pedir al usuario una frase y un carácter, y decir si la frase contiene ese carácter.
public class Ej04 {
	public static boolean contiene(String s, char c) {
//		return s.indexOf(c) != -1;
		return s.contains(c + "");
	}
	
	public static void main(String[] args) {
		System.out.println(contiene("hola", 'h'));
		System.out.println(contiene("hola", 'x'));
	}
	
}
