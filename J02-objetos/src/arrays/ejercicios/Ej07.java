package arrays.ejercicios;

import arrays.ArrayUtil;

//Similar al anterior pero que intercale los elementos. 
//	Ej: recibe [1, 2, 3, 4, 5] y [6, 7]; retorna [1, 6, 2, 7, 3, 4, 5].
public class Ej07 {

	public static double[] intercala(double[] v1, double[] v2) {
		double[] resu = new double[v1.length + v2.length];
		double[] mayor = v1;
		double[] menor = v2;
		if (v2.length > v1.length) {
			mayor = v2;
			menor = v1;
		}
		
		for (int i = 0; i < menor.length; i++) {
			resu[2 * i] = v1[i];
			resu[2 * i + 1] = v2[i];
		}
		for (int i = menor.length; i < mayor.length; i++) {
			resu[menor.length + i] = mayor[i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
		double[] a = {15.6, 8};
		double[] b = {1,2,3,4,5,6,7};
		
		ArrayUtil.muestra(intercala(a, b));
		ArrayUtil.muestra(intercala(b, a));
	}
}
