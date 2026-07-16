package es.cursoalcobendas.tienda.persistencia;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Emf {

	private static EntityManagerFactory emf;
	
	private Emf() {}
	
	public static EntityManagerFactory get() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("tienda");
		return emf;
	}
}
