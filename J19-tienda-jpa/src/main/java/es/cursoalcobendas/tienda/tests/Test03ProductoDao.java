package es.cursoalcobendas.tienda.tests;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.persistencia.FabricanteDao;
import es.cursoalcobendas.tienda.persistencia.FabricanteDaoImpl;
import es.cursoalcobendas.tienda.persistencia.ProductoDao;
import es.cursoalcobendas.tienda.persistencia.ProductoDaoImpl;

public class Test03ProductoDao {
	public static void main(String[] args) {
		ProductoDao pDao = new ProductoDaoImpl();
		FabricanteDao fDao = new FabricanteDaoImpl();
		
		Fabricante f = fDao.findById(1); 
		System.out.println("----------");
		
		pDao.findByFabricante(f);
		
	}
}
