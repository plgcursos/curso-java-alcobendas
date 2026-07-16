package es.cursoalcobendas.tienda.persistencia;

import jakarta.persistence.EntityManagerFactory;

public class Emf {

	private static EntityManagerFactory emf;
	
	private Emf() {}
	
	public static EntityManagerFactory get() {
		
		return emf;
	}
}
