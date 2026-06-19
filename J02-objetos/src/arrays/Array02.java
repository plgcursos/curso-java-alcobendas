package arrays;

public class Array02 {
	
	public static void main(String[] arg) {
		int v1, v2;
		if(arg.length != 2) {
			System.out.println("se debe ejecutar con dos parametros enteros");
			return;
		}
		
		v1 = Integer.parseInt(arg[0]);
		v2 = Integer.parseInt(arg[1]);
		
		System.out.println(v1 + v2);
	}

}
