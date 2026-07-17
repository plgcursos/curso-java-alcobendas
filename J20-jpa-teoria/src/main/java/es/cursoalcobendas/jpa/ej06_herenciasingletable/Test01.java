package es.cursoalcobendas.jpa.ej06_herenciasingletable;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.get().createEntityManager();
		
		Circulo c = em.find(Circulo.class, 30);
		
		Rectangulo r = em.find(Rectangulo.class, 41);
		
		System.out.println(c);
		System.out.println(r);
	}
}
