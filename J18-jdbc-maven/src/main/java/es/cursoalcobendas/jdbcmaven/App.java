package es.cursoalcobendas.jdbcmaven;

import es.cursoalcobendas.jdbcmaven.modelo.Fabricante;
import es.cursoalcobendas.jdbcmaven.persistencia.FabricanteDao;
import es.cursoalcobendas.jdbcmaven.persistencia.FabricanteDaoImpl;

public class App {
    public static void main(String[] args) {
    	FabricanteDao fDao = new FabricanteDaoImpl();
 
    	Fabricante nuevo = fDao.insert(new Fabricante("lO QUE SEA"));
    	
    	System.out.println(nuevo);
    	System.out.println();
    	
    	fDao.findAll().forEach(System.out::println);
    	System.out.println();
    	
    	fDao.findByNombre("s").forEach(System.out::println);
 
    }
}
