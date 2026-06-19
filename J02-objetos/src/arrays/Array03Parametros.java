package arrays;

public class Array03Parametros {

	public static void cambia(int a) {
		System.out.println(a);
		a = 0;
	}
	
	public static void cambia(int[] v) {
		ArrayUtil.muestra(v);
		for (int i = 0; i < v.length; i++) {
			v[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		int a = 55;
		cambia(a);
		System.out.println(a);
		System.out.println("----------");
		
		int[] numeros = {55, 55, 55, 55};
		cambia(numeros);
		ArrayUtil.muestra(numeros);
	}
}

//Programa en c con el ejemplo por valor y por referencia
//Compilador en línea: https://www.onlinegdb.com/online_c_compiler
/*
#include <stdio.h>

void cambiaPorValor(int a) {
    a = 0;
}

void cambiaPorReferencia(int *a) {
    *a = 0;
}

int main() {
    int a = 55;
    
    printf("Valor original de a: %d\n", a);
    
    cambiaPorValor(a);
    printf("Despues de cambiaPorValor. Valor de a: %d\n", a);
    
    cambiaPorReferencia(&a);
    printf("Despues de cambiaPorReferencia. Valor de a: %d\n", a);

    return 0;
}
*/