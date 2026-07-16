package es.cursoalcobendas.tienda.persistencia;

import java.util.List;

import es.cursoalcobendas.tienda.modelo.Fabricante;

public interface FabricanteDao {

	List<Fabricante> findAll();
	
	List<Fabricante> findByNombre(String nombre);
	
	Fabricante insert(Fabricante f);

}
