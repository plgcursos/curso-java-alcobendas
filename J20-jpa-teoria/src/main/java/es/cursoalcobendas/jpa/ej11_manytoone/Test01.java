package es.cursoalcobendas.jpa.ej11_manytoone;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Partido p = em.find(Partido.class, 2);
		
		System.out.println(p);
	}
}
