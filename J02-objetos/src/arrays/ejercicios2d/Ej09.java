package arrays.ejercicios2d;

import java.util.Random;

import arrays.ArrayUtil;

//Desarrollar un método que reciba dos enteros, el primero (f) la cantidad de filas y el
//segundo (c) la cantidad de columnas. Deberá generar y retornar una matriz de dos
//dimensiones de f+1 filas y c+1 columnas, con números aleatorios entre 0 y 99 en todas las
//celdas, excepto en la última fila y en la última columna, que deberán contener los
//sumatorios de las filas o columnas correspondientes, similar a una hoja Excel.
public class Ej09 {

	public static double[][] generaMatriz(int f, int c){
		double[][] m = new double[f+1][c+1];
		Random r = new Random();
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				m[i][j] = Math.round(r.nextDouble(10));
			}
		}
		calculaTotales(m);
		return m;
	}
	
	public static void calculaTotales(double[][] m) {
		for (int i = 0; i < m.length - 1; i++) {
			for (int j = 0; j < m[i].length - 1; j++) {
				m[m.length - 1][j] += m[i][j];
				m[i][m[i].length - 1] += m[i][j];
				m[m.length - 1][m[i].length - 1] += m[i][j];
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayUtil.muestra(generaMatriz(7, 5));
	}
}
