package es.cursoalcobendas.tienda.persistencia;

import java.util.List;
import java.util.Set;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;

public interface ProductoDao {
	
	public abstract List<Producto> findAll();
	
	List<Producto> findByNombre(String nombre);
	
	Producto save(Producto p);
	
	Producto findById(Integer id);
	
	void deleteById(Integer id);
	
	void delete(Producto p);

	Set<Producto> findByFabricante(Fabricante f);
	
	List<Producto> findByFabricante(Integer idFabricante);
}
