package arrays.ejercicios2d;

import java.util.Random;

import arrays.ArrayUtil;

public class Ej01 {
	public static void main(String[] args) {
		double[][] m = new double[5][3];
		Random r = new Random();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = r.nextDouble(100000);
			}
		}
		
		ArrayUtil.muestra(m);
	}
}
