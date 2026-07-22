package es.cursoalcobendas.ejerciciojpa.consultas;

import es.cursoalcobendas.ejerciciojpa.modelo.ClientePorCategoria;

public class TestRecord {

	public static void main(String[] args) {
		
		ClientePorCategoria cp = new ClientePorCategoria("VIP", 25L);
		
		System.out.println(cp.categoria());
		System.out.println(cp.cantidad());
		
		System.out.println(cp);
		
	}
}
