package es.cursoalcobendas.jpa.ej07_herenciajoined;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		
		EntityManager em = Emf.get().createEntityManager();
		
		Circulo2 c = em.find(Circulo2.class, 40);
		
		Rectangulo2 r = em.find(Rectangulo2.class, 70);
		
		System.out.println(c);
		System.out.println(r);
	}
}
