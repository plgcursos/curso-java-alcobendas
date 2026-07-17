package es.cursoalcobendas.jpa.ej04_insertable;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Persona04 p = em.find(Persona04.class, 7);
		
		System.out.println(p);
		System.out.println(p.getDom());
		
	}
}
