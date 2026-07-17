package es.cursoalcobendas.jpa.ej03_pkcompuesta;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test03Persona03B {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Persona03B p = em.find(Persona03B.class, new Dni(9856478, 'N'));
		
		System.out.println(p);

	}
}
