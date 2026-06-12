package introduccion.ejercicios.ejercicios06;

public class E01_FactorialRecursivo {

	public static long factorial(long n) {
		if (n == 0)
			return 1;
		return n * factorial(n - 1);
	}
	
	public static void main(String[] args) {
		System.out.println(factorial(50000));
	}
	
	
	
	public static int factorialDe3() {
		return 3 * factorialDe2();
	}
	public static int factorialDe2() {
		return 2 * factorialDe1();
	}
	public static int factorialDe1() {
		return 1 * factorialDe0();
	}
	public static int factorialDe0() {
		return 1;
	}
}
