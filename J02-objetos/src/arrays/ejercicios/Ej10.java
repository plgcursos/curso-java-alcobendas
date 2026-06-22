package arrays.ejercicios;

public class Ej10 {
	static String[] users = {"admin", "pepe"};
	static String[] passwords = {"xadmin", "xpepe"};
	
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Ejecutar con usuario y password");
			return;
		}
		int pos = existeUsuario(args[0]);
		if (pos == -1) {
			System.out.println("El ususario " + args[0] + " no existe");
			return;
		}
		if (!passwordOK(pos, args[1])) {
			System.out.println("El password es incorrecto");
			return;
		}
		
		System.out.println("Bienvenido al Sistema, que no hace nada!");
	}
	
	public static int existeUsuario(String usr) {
		int pos = -1;
		for (int i = 0; i < users.length && pos == -1; i++) {
			if (users[i].equals(usr))
				pos = i;
		}
		return pos;
	}
	
	public static boolean passwordOK(int pos, String pwd) {
		return passwords[pos].equals(pwd);
	}
}
