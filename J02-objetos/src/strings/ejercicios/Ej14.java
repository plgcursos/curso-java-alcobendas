package strings.ejercicios;

//Desarrolle un método llamado capitalize que ponga en mayúsculas cada palabra de una frase recibida como parámetro. 
//	Por ej: si se recibe “Congreso internacional de programación de String”, debe devolver, 
//	“Congreso Internacional De Programación De String”. 
//	Utilice Character.toUpperCase(char c)
public class Ej14 {

	public static String capitalize(String s) {
		s = s.toLowerCase().trim().replaceAll(" +", " ");
		String resu = "" + Character.toUpperCase(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			resu += s.charAt(i);
			if (s.charAt(i) == ' ')
				resu += Character.toUpperCase(s.charAt(++i));
		}
		return resu;
	}
	
	public static void main(String[] args) {
		System.out.println(capitalize("Universal serial bus"));
		System.out.println(capitalize("  Universal serial      Bus   "));
		System.out.println(capitalize("  Universal serial      Bus   "));
		System.out.println(capitalize("  Universal serial      Bus   "));
		System.out.println(capitalize("  Congreso internacional de programación de String   "));
		System.out.println(capitalize("  CONGRESO INTERNACIONAL DE PROGRAMACIÓN DE STRING   "));
	}
}
