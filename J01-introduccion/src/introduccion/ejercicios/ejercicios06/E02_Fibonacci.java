package introduccion.ejercicios.ejercicios06;

// 0, 1, 1, 2, 3, 5, 8, 13, 21
public class E02_Fibonacci {

	public static int fibonacci(int n) {
		if (n <= 1)
			return n;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(8));
	}
}
