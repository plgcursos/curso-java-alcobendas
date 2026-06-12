package introduccion.ejemplos;

public class T11SwitchNuevo {
	public static void main(String[] args) {
		
		int dia = 3;
		switch (dia) {
		case 1 -> System.out.println("lunes");
		case 2 -> System.out.println("martes");
		case 3 -> System.out.println("miercoles");
		case 4 -> System.out.println("jueves");
		case 5 -> System.out.println("viernes");
		case 6 -> System.out.println("sabado");
		case 7 -> System.out.println("domingo");
		default -> System.out.println("ERROR");
		}
	}
}
