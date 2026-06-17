package strings.ejercicios;

//Haga otra versión del método, pero que reciba una cadena, un carácter y la cantidad de dígitos 
//	entre las que se debe insertar el carácter.
public class Ej13 {

	public static String inserta(String s, char sep, int cant) {
		String resu = "";
		int ant = 0;
		for (int i = cant; i < s.length(); i+=cant) {
			resu += s.substring(ant, i) + sep;
			ant = i;
		}
		return resu + s.substring(ant);
	}
	
	public static void main(String[] args) {
		System.out.println(inserta("1921680012", '.', 4));
	}
}
