package strings.ejercicios;

//Método que reciba una cadena y retorne el número de vocales que contiene.
public class Ej07 {

	public static int cuentaVocales(String s) {
		s = s.toLowerCase();
		int cant = 0;
		for (int i = 0; i < s.length(); i++) {
			if ("aeiou".contains(s.charAt(i) + ""))
				cant++;
		}
		return cant;
	}
	
	public static void main(String[] args) {
		System.out.println(cuentaVocales("Murcielago"));
		System.out.println(cuentaVocales("Otro Murcielago"));
	}
}
