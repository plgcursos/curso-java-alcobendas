package strings.ejercicios;

//Desarrolle un método que reciba una cadena con una expresión de una operación simple (+, -, *, /) 
//	con dos operandos y retorne el resultado como double.
public class Ej15 {
	
	public static double calcula(String exp) {
		exp = exp.replace(" ", "");
		double resu = 0;
		String operadores = "+-*/";
		int posOp = -1;
		for (int i = 0; i < 4 && posOp == -1; i++) {
			posOp = exp.indexOf(operadores.charAt(i));
		}
		
		double n1 = Double.parseDouble(exp.substring(0, posOp));
		double n2 = Double.parseDouble(exp.substring(posOp + 1));
		
//		return switch (exp.charAt(posOp)) {
		resu = switch (exp.charAt(posOp)) {
		case '+' -> n1 + n2;
		case '-' -> n1 - n2;
		case '*' -> n1 * n2;
		case '/' -> n1 / n2;
		default -> 0;
		};
		
		return resu;
	}

	public static void main(String[] args) {
		System.out.println(calcula("5*9"));
		System.out.println(calcula("15.25 + 9.75"));
	}
}
