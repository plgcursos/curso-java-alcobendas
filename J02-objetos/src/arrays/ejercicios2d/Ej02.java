package arrays.ejercicios2d;

//Desarrollar un método que reciba un array de dos dimensiones de double y retorne la suma
//total de todos los elementos.
public class Ej02 {

	public static double sumaElementos(double[][] v) {
		double suma = 0;
		for (int i = 0; i < v.length; i++) {
			for (int j = 0; j < v[i].length; j++) {
				suma += v[i][j];
			}
		}
		return suma;
	}
	
	public static void main(String[] args) {
		double[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
		System.out.println(sumaElementos(m));
	}
}
