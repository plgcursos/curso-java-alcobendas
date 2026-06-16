package strings;

public class CadenasIgualdad {

	public static void main(String[] args) {
		
		String c1 = new String("hola");
		String c2 = new String("hola");
		
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		
		System.out.println("-------------------");
		
		c1 = c2;
		System.out.println(c1 == c2);
		System.out.println(c1.equals(c2));
		
		c1 = "adios";
		System.out.println(c1);
		System.out.println(c2);
		System.out.println("-------------------");
		
		String c3 = "hola";
		String c4 = "hola";
		
		System.out.println(c3 == c4);
		
	}
}
