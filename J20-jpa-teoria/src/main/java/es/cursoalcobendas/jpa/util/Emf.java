package es.cursoalcobendas.jpa.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Emf {

	private static EntityManagerFactory emf;
	
	private Emf() {}
	
	public static EntityManagerFactory get() {
		if (emf == null)
			emf = Persistence.createEntityManagerFactory("curso_jpa");
		return emf;
	}
}
