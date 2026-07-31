package es.cursosanblas.recuperacion;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.cursoalcobendas.recuperacion.modelo.Cliente;
import es.cursoalcobendas.recuperacion.modelo.Cuenta;
import es.cursoalcobendas.recuperacion.modelo.Movimiento;
import es.cursoalcobendas.recuperacion.modelo.Tarjeta;
import jakarta.persistence.EntityManager;

public class Test01Entidades extends JpaTestBase {

	private EntityManager em;
	
	@BeforeEach
	void creaEm() {
		em = emf.createEntityManager();
	}
	
	@AfterEach
	void cierraEm() {
		em.close();
	}
	
	@Test
	void testCliente() {
		Cliente cli = em.find(Cliente.class, 29);
		assertNotNull(cli);
		assertEquals(29, cli.getIdCliente());
		assertEquals("15750865M", cli.getNif());
	}
		
	@Test
	void testCuenta() {	
		Cuenta cta = em.find(Cuenta.class, 194);
//		Cuenta:
//		194
//		ES0600784941114272641817
		assertNotNull(cta);
		assertEquals(194, cta.getIdCuenta());
		assertEquals("ES0600784941114272641817", cta.getNumero());
	}

	@Test
	void testTarjeta() {
		Tarjeta t = em.find(Tarjeta.class, 318);
//		Tarjeta:
//		318
//		5552971835478028
//		Mastercard
//		CREDITO
//		2029
//		11
		assertNotNull(t);
		assertEquals(318, t.getIdTarjeta());
		assertEquals("5552971835478028", t.getPan());
		assertEquals(11, t.getMesVencimiento());
	}
	
	@Test
	void testMovimiento() {	
		
		Movimiento m = em.find(Movimiento.class, 50);
//		Movimiento:
//		2020-08-04
//		1096.78
//		Iberia
			
		assertNotNull(m);
		assertEquals(1096.78, m.getImporte());
		assertEquals("Iberia", m.getProveedor());
	}

}
