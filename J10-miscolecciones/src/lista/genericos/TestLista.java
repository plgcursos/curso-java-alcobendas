package lista.genericos;

import model.Circulo;
import model.Figura;
import model.Rombo;

public class TestLista {
	public static void main(String[] args) {
		
		ListaArray<Double> lD = new ListaArray<Double>();
		lD.agregar(15.);
		lD.agregar(589.45);
		lD.agregar(0.);
		lD.agregar(-456.89);
		
		System.out.println(lD.largo());
		System.out.println(lD.buscar(3));
		
		
		ListaEnlazada<Figura> listaFigs = new ListaEnlazada<Figura>();
		
		listaFigs.agregar(new Circulo(1, 2, 3));
		listaFigs.agregar(new Rombo(2, 4, 3, 5));
		
		for (int i = 0; i < listaFigs.largo(); i++) {
			System.out.println(listaFigs.buscar(i));
		}
		
		String mensaje = "Figurita: " + listaFigs.buscar(0);
		System.out.println(mensaje);
	}
}

