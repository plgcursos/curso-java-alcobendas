package arrays.ejercicios2d;

import arrays.ArrayUtil;

//7. Desarrollar un método que reciba un array de dos dimensiones de double y un número de
//fila y retorne la fila indicada.

//8. Desarrollar un método que reciba un array de dos dimensiones de double y un número de
//columna y retorne la columna indicada.
public class Ej07Y08 {

	public static double[] getFila(double[][] m, int fila){
		if (fila < 1 || fila > m.length)
			return null;
		return m[fila - 1].clone();
	}
	
	public static double[] getColumna(double[][] m, int col) {
		if (col < 1 || col > m[0].length)
			return null;
		double[] resu = new double[m.length];
		for (int i = 0; i < m.length; i++)
			resu[i] = m[i][col - 1];
		return resu;
	}

	public static void main(String[] args) {
		double[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}};
		double[][] m2 = {{1,2,3}, {4,5,6}};
		double[][] m3 = {{1,2} ,{3,4}, {5,6}};
		
		ArrayUtil.muestra(m1);
		System.out.println();
		ArrayUtil.muestra(getFila(m1, 2));
		ArrayUtil.muestra(getColumna(m1, 2));
		System.out.println("---------------------");
		
		ArrayUtil.muestra(m2);
		System.out.println();
		ArrayUtil.muestra(getFila(m2, 2));
		ArrayUtil.muestra(getColumna(m2, 2));
		System.out.println("---------------------");
		
		ArrayUtil.muestra(m3);
		System.out.println();
		ArrayUtil.muestra(getFila(m3, 2));
		ArrayUtil.muestra(getColumna(m3, 2));
		System.out.println("---------------------");
	}
}
