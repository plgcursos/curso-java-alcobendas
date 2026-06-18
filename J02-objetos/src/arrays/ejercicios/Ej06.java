package arrays.ejercicios;

import arrays.ArrayUtil;

//Desarrollar un método que reciba dos arrays de enteros y retorne un tercero con todos los elementos del primero 
//	y luego los del segundo. Ej: recibe [1, 2, 3] y [4, 5]; retorna [1, 2, 3, 4, 5].
public class Ej06 {
	
	public static int[] concat(int[] v1, int[] v2) {
		int[] resu = new int[v1.length + v2.length];
		
		for (int i = 0; i < v1.length; i++) {
			resu[i] = v1[i];
		}
		
		for (int i = v1.length; i < resu.length; i++) {
			resu[i] = v2[i - v1.length];
		}
		
		return resu;
	}
	
	public static void main(String[] args) {
		ArrayUtil.muestra(concat(new int[] {1,2,3,4,5}, new int[] {6,7,8,9}));
	}
}
