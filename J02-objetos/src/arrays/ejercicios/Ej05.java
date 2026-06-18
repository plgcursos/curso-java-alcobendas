package arrays.ejercicios;

import arrays.ArrayUtil;

//Desarrollar un método que reciba, dos arrays de doubles del mismo tamaño y retorne un nuevo array con la suma de los elementos que están en la misma posición.
//a.Repetir el método, pero para arrays de diferentes tamaños.
public class Ej05 {

	//Resolucion para diferentes tamaños
	public static double[] suma(double[] v1, double[] v2) {
		double[] mayor = v1;
		double[] menor = v2;
		if (v2.length > v1.length) {
			mayor = v2;
			menor = v1;
		}
		double[] resu = new double[mayor.length];
		
		for (int i = 0; i < menor.length; i++) {
			resu[i] = mayor[i] + menor[i];
		}
		for (int i = menor.length; i < resu.length; i++) {
			resu[i] = mayor[i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
		double[] a = {15.6, 8};
		double[] b = {1,2,3,4,5,6,7};
		
		ArrayUtil.muestra(suma(a, b));
		ArrayUtil.muestra(suma(b, a));
	}
}
