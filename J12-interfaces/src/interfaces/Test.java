package interfaces;

public class Test {
	public static void main(String[] args) {
		
		System.out.println(EjemploInterface.ALGO);
		EjemploInterface.haceAlgoEstatico();
		
		System.out.println(EjemploClaseImplementa.ALGO);
		
		EjemploClaseImplementa ej = new EjemploClaseImplementa();
		
		ej.haceAlgo();
		ej.haceOtraCosa();
	}
}
