package es.cursoalcobendas.jpa.ej12_manytomany;

import es.cursoalcobendas.jpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01 {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Equipo e = em.find(Equipo.class, 10);
		
		System.out.println(e);
	}
}
