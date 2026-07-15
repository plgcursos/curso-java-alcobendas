package es.cursoalcobendas.jdbcmaven.persistencia;

import java.util.List;

import es.cursoalcobendas.jdbcmaven.modelo.Fabricante;

public interface FabricanteDao {

	List<Fabricante> findAll();
	
	List<Fabricante> findByNombre(String nombre);
	
	Fabricante insert(Fabricante f);

}
