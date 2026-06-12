package introduccion.ejemplos;

public class T09cFor {

	public static void main(String[] args) {
		
		// x incremente de 1 hasta n
		// y decremente de 1 desde m hasta 0
		
		int n = 10;
		int m = 7;
		
		for (int x = 1, y = m; x <= n && y >= 0; x++, y-- ) {
			System.out.println(x + ", " + y);
		}
		
		System.out.println("---------");
		for (int x = 1, y = m; x <= y; x++, y-- ) {
			System.out.println(x + ", " + y);
		}
	}
}
