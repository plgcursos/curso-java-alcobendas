package arrays;

import java.util.Arrays;
import java.util.Random;

public class Array05Ordenacion {

	public static void insercion(double[] v) {
		for (int i = 1; i < v.length; i++) {
			boolean esMenor = true;
			for (int j = i; j > 0 && esMenor; j--) {
				if (v[j] < v[j-1])
					intercambia(v, j, j-1);
				else
					esMenor = false;
			}
		}
	}
	
	public static void quickSort(double[] v) {
		quickSort(v, 0, v.length - 1);
	}
	
	public static void quickSort(double[] v, int izq, int der) {
		double valPivote = (v[izq] + v[der]) / 2;
		int i = izq;
		int d = der;
		while(i < d) {
			while(v[i] < valPivote) i++;
			while(v[d] > valPivote) d--;
			if(i < d) {
				intercambia(v, i, d);
				i++;
				d--;
			}
		}
		if (izq < d) quickSort(v, izq, d);
		if (i < der) quickSort(v, i, der);
	}
	
	public static void intercambia(double[] v, int i, int d) {
		double aux = v[i];
		v[i] = v[d];
		v[d] = aux;
	}
	
	public static void main(String[] args) {
		double[] v1 = {77, 4, 78, 60, 100, 35, 74};
//		insercion(v1);
		quickSort(v1);
		ArrayUtil.muestra(v1);
		
		v1 = generaArray(50);
		insercion(v1);
		ArrayUtil.muestra(v1);
		
		long t0, tf;
		double[] v2 = generaArray(200_000_000);
		double[] v3 = v2.clone();
		double[] v4 = v2.clone();
		
//		t0 = System.currentTimeMillis();
//		insercion(v2);
//		tf = System.currentTimeMillis();
//		System.out.println("Insercion: " + (tf-t0));
		
		t0 = System.currentTimeMillis();
		Arrays.sort(v3);
		tf = System.currentTimeMillis();
		System.out.println("QuickSort libreria: " + (tf-t0));
		
		t0 = System.currentTimeMillis();
		quickSort(v4);
		tf = System.currentTimeMillis();
		System.out.println("QuickSort: " + (tf-t0));
	}
	
	public static double[] generaArray(int cant) {
		double[] nuevo = new double[cant];
		Random r = new Random();
		for (int i = 0; i < nuevo.length; i++) {
			nuevo[i] = r.nextDouble(cant * 2);
		}
		return nuevo;
	}
	
	
}
