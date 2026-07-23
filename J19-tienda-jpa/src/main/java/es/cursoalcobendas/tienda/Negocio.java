package es.cursoalcobendas.tienda;

import java.util.Set;

import es.cursoalcobendas.tienda.modelo.Fabricante;

public interface Negocio {

	Fabricante buscarFabricante(Integer id);
	
	/**
	 * Busca todos los fabricantes
	 * 
	 * @return Set de fabricantes ordenado por descripcion
	 */
	Set<Fabricante> buscarFabricantes();
	
	/**
	 * Busca los fabricantes que contengan "desc" en el nombre
	 * @param desc
	 * @return Set de fabricantes ordenado por id
	 */
	Set<Fabricante> buscarFabricantes(String desc);
	
	Fabricante crearFabricante(Fabricante nuevo);
	
	
}
