package arrays.ejercicios2d;

import arrays.ArrayUtil;

//Desarrollar un método que reciba un array de dos dimensiones de double (matriz
//matemática) y calcule la Traza. La traza es la sumatoria de los elementos de la diagonal
//principal de una matriz cuadrada. Nosotros la calcularemos para cualquier matriz, no sólo
//cuadradas.
public class Ej03 {
	public static double traza(double[][] v) {
		double traza = 0;
		double minimo = Math.min(v.length, v[0].length);
		for (int i = 0; i < minimo; i++) {
			traza += v[i][i];
		}
		return traza;
	}
	
	public static void main(String[] args) {
		double[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}};
		ArrayUtil.muestra(m1);
		System.out.println(traza(m1));

		double[][] m2 = {{1,2,3}, {4,5,6}};
		ArrayUtil.muestra(m2);
		System.out.println(traza(m2));
		
		double[][] m3 = {{1,2} ,{3,4}, {5,6}};
		ArrayUtil.muestra(m3);
		System.out.println(traza(m3));
	}
}
