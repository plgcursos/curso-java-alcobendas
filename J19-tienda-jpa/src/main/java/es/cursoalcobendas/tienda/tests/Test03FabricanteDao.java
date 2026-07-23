package es.cursoalcobendas.tienda.tests;

import java.util.List;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.persistencia.FabricanteDao;
import es.cursoalcobendas.tienda.persistencia.FabricanteDaoImpl;

public class Test03FabricanteDao {
	public static void main(String[] args) {
		
		FabricanteDao fDao = new FabricanteDaoImpl();
		
		Fabricante f = fDao.findById(1);
		
		System.out.println(f);
		f.getProductos().forEach(System.out::println);
		System.out.println("-----------------");
		
		List<Fabricante> todos = fDao.findAll();
		todos.forEach(System.out::println);
		
//		Fabricante primero = todos.get(0);
//		primero.getProductos().forEach(System.out::println);
		System.out.println("-----------------");

		List<Fabricante> nombres = fDao.findByNombre("w");
		nombres.forEach(System.out::println);
		System.out.println("---------------------");
		
		Fabricante nuevo = new Fabricante("Apple");
		System.out.println(nuevo);
		System.out.println(fDao.save(nuevo));
	}
}	
