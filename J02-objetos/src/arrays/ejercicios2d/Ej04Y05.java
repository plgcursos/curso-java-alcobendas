package arrays.ejercicios2d;

import arrays.ArrayUtil;

//4. Desarrollar un método que reciba un array de dos dimensiones de double y retorne la suma
//de cada fila.
//5. Desarrollar un método que reciba un array de dos dimensiones de double y retorne la suma
//de cada columna.
public class Ej04Y05 {
	
	public static double[] sumaFilas(double[][] m) {
		double sumas[] = new double[m.length];
		
		for (int i = 0; i < m.length; i++) 
			for (int j = 0; j < m[i].length; j++) 
				sumas[i] += m[i][j];
		
		return sumas;
	}
	
	public static double[] sumaColumnas(double[][] m) {
		double sumas[] = new double[m[0].length];
		
		for (int j = 0; j < m[0].length; j++) 
			for (int i = 0; i < m.length; i++) 
				sumas[j] += m[i][j];
		
		return sumas;
	}
	
	public static void main(String[] args) {
		double[][] m1 = {{1,2,3}, {4,5,6}, {7,8,9}};
		double[][] m2 = {{1,2,3}, {4,5,6}};
		double[][] m3 = {{1,2} ,{3,4}, {5,6}};

		ArrayUtil.muestra(m1);
		ArrayUtil.muestra(sumaFilas(m1));
		ArrayUtil.muestra(sumaColumnas(m1));
		System.out.println();

		ArrayUtil.muestra(m2);
		ArrayUtil.muestra(sumaFilas(m2));
		ArrayUtil.muestra(sumaColumnas(m2));
		System.out.println();

		ArrayUtil.muestra(m3);
		ArrayUtil.muestra(sumaFilas(m3));
		ArrayUtil.muestra(sumaColumnas(m3));
		System.out.println();

	}
}
