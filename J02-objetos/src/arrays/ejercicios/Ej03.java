package arrays.ejercicios;

import arrays.ArrayUtil;

//Desarrollar un método que reciba un array de enteros y retorne otro con los elementos ordenados exactamente 
//	al revés que el original.
public class Ej03 {

	public static int[] invierte(int[] v) {
		int[] resu = new int[v.length];
		for (int i = 0; i < v.length; i++) {
			resu[i] = v[v.length - 1 - i];
		}
		return resu;
	}
	
	public static void main(String[] args) {
		int[] nums = {15, 5, -9, 0, 8};
		
		int[] numsInv = invierte(nums);
		
		ArrayUtil.muestra(nums);
		ArrayUtil.muestra(numsInv);
		
	}
}
