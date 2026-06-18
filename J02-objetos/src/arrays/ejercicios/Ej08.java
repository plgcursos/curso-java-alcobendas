package arrays.ejercicios;

import arrays.ArrayUtil;

//Desarrollar un método que reciba un array de doubles y, en el mismo array, intercambie los elementos en espejo, 
//	es decir, el primero por el último, el segundo por el penúltimo y así sucesivamente. 
//  No se puede utilizar otro array. Ej: recibe [1, 2, 3, 4, 5]; el array queda como [5, 4, 3, 2, 1].
public class Ej08 {
	
	public static void invierte(double[] v) {
		double aux;
		for (int i = 0; i < v.length / 2; i++) {
			aux = v[i];
			v[i] = v[v.length - 1 - i];
			v[v.length - 1 - i] = aux;
		}
	}
	
	public static void main(String[] args) {
		double[] nums = {1,2,3,4,5,6,7};
		ArrayUtil.muestra(nums);
		invierte(nums);
		ArrayUtil.muestra(nums);
	}
}
