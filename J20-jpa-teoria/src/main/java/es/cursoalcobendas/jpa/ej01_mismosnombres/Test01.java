package es.cursoalcobendas.jpa.ej01_mismosnombres;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		System.out.println(em.find(Persona.class, 6));
	}
}
