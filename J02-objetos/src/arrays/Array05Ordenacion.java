package arrays;

import java.util.Random;

public class Array05Ordenacion {

	public static void insercion(double[] v) {
		for (int i = 1; i < v.length; i++) {
			boolean esMenor = true;
			for (int j = i; j > 0 && esMenor; j--) {
				if (v[j] < v[j-1])
					intercambia(v, j, j-1);
				else
					esMenor = false;
			}
		}
	}
	
	public static void intercambia(double[] v, int i, int d) {
		double aux = v[i];
		v[i] = v[d];
		v[d] = aux;
	}
	
	public static void main(String[] args) {
		double[] v1 = {77, 4, 78, 60, 100, 35, 74};
		insercion(v1);
		ArrayUtil.muestra(v1);
		
	}
	
	public static double[] generaArray(int cant) {
		double[] nuevo = new double[cant];
		Random r = new Random();
		for (int i = 0; i < nuevo.length; i++) {
			nuevo[i] = r.nextDouble(cant * 2);
		}
		return nuevo;
	}
	
	
}
