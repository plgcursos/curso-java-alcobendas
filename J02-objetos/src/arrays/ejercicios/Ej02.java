package arrays.ejercicios;

import arrays.ArrayUtil;

//Desarrollar un método que reciba un array de enteros y retorne otro con los valores originales elevados al cuadrado.
public class Ej02 {

	public static int[] cuadrado(int[] v) {
		int[] resu = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			resu[i] = v[i] * v[i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
		int[] nums = {15, 5, -9, 0, 8};
		
		int[] numsCuad = cuadrado(nums);
		
		ArrayUtil.muestra(nums);
		ArrayUtil.muestra(numsCuad);
		
	}
}
