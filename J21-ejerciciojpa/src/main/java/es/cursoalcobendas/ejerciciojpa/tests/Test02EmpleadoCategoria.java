package es.cursoalcobendas.ejerciciojpa.tests;

import es.cursoalcobendas.ejerciciojpa.modelo.Empleado;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test02EmpleadoCategoria {
	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		System.out.println(em.find(Empleado.class, 15));

	}
}
