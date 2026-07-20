package es.cursoalcobendas.jpa.ej08_onetoone;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Contacto c = em.find(Contacto.class, 7);
		
		System.out.println(c);
	}
}
