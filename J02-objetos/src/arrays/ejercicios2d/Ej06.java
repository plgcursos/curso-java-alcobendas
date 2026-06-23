package arrays.ejercicios2d;

import arrays.ArrayUtil;

//Desarrollar un método que reciba una matriz matemática (dos dimensiones) de double y
//retorne la matriz traspuesta. La matriz traspuesta se genera cambiando filas por columnas
public class Ej06 {

	public static double[][] traspuesta(double[][] m){
		double[][] t = new double[m[0].length][m.length];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				t[j][i] = m[i][j];
			}
		}
		return t;
	}
	
	public static void main(String[] args) {
		double[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}};
		double[][] m2 = {{1,2,3}, {4,5,6}};
		double[][] m3 = {{1,2} ,{3,4}, {5,6}};

		ArrayUtil.muestra(m1);
		System.out.println();
		ArrayUtil.muestra(traspuesta(m1));
		System.out.println("---------------------");
		
		ArrayUtil.muestra(m2);
		System.out.println();
		ArrayUtil.muestra(traspuesta(m2));
		System.out.println("---------------------");
		
		ArrayUtil.muestra(m3);
		System.out.println();
		ArrayUtil.muestra(traspuesta(m3));
		System.out.println("---------------------");
	}
}
