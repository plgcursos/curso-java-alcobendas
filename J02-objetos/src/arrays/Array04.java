package arrays;

public class Array04 {
	
//	public static int suma(int a, int b) {
//		return a + b;
//	}
//	
//	public static int suma(int a, int b, int c) {
//		return a + b + c;
//	}
//	
	public static int suma(int... v) {
		int suma = 0;
		for (int i = 0; i < v.length; i++) {
			suma += v[i];
		}
		return suma;
	}
	
	public static void otro(String algo, String otro, int num, String[] mas, String... xxx) {
		
	}
	
	public static void main(String[] args) {
		System.out.println(suma(5, 8));
		System.out.println(suma(15, 5, 8));
		System.out.println(suma(15, 5, 8, 78));
		int[] nums = {1,8,7,9,10};
		System.out.println(suma(nums));
		
		System.out.println(suma(1,2,5,4,7,8,55,2,7));
	}
}
