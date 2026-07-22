package es.cursoalcobendas.ejerciciojpa.tests;

import es.cursoalcobendas.ejerciciojpa.modelo.Cliente;
import es.cursoalcobendas.ejerciciojpa.modelo.Colaborador;
import es.cursoalcobendas.ejerciciojpa.modelo.Empleado;
import es.cursoalcobendas.ejerciciojpa.util.Emf;
import jakarta.persistence.EntityManager;

public class Test01Herencia {

	public static void main(String[] args) {
		EntityManager em = Emf.get().createEntityManager();
		
		Colaborador col = em.find(Colaborador.class, 6);
		System.out.println(col);
		
		System.out.println(em.find(Empleado.class, 15));
		
		System.out.println(em.find(Cliente.class, 7));
	}
}
