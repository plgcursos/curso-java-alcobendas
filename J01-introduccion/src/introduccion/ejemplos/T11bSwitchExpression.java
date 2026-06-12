package introduccion.ejemplos;

public class T11bSwitchExpression {

	public static void main(String[] args) {
		int dia = 45;
		
		String nomDia = switch (dia) {
		case 1 -> "lunes";
		case 2 -> "martes";
		case 3 -> "miercoles";
		case 4 -> "jueves";
		case 5 -> "viernes";
		case 6 -> "sabado";
		case 7 -> "domingo";
		default -> { 
			// genero un log con el error
			System.out.println("Estoy haciendo log");
			yield "ERROR";
			}
		};
		
		System.out.println(nomDia);
	}
}
