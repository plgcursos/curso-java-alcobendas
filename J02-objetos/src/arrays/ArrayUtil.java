package arrays;

public class ArrayUtil {
	
	public static void muestra(int[] v) {
		System.out.print("[");
		for (int i = 0; i < v.length - 1; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.println(v[v.length - 1] + "]");
	}
	
	public static void muestra(double[] v) {
		System.out.print("[");
		for (int i = 0; i < v.length - 1; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.println(v[v.length - 1] + "]");
	}
	
	public static void muestra(String[] v) {
		System.out.print("[");
		for (int i = 0; i < v.length - 1; i++) {
			System.out.print(v[i] + ", ");
		}
		System.out.println(v[v.length - 1] + "]");
	}
	
	public static void muestra(double[][] m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.printf("%12.3f", m[i][j]);
			}
			System.out.println();
		}
	}
}
