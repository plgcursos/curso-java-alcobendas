package introduccion.ejemplos;

public class T08BucleFor {
	public static void main(String[] args) {
		//Mostrar los nros naturales hasta el 50
		
		int cont = 1;
		
		while(cont <= 50) {
			System.out.println(cont);
			cont++;
		}
		
		System.out.println("--------------------------");
		
		for(int i = 2; i <= 50; i = i + 2) {
			System.out.println(i);
		}
		
		System.out.println("--------------------------");
		
		for (int i = 10; i >= 0; i--) {
			System.out.println(i);
		}
	}
}
