package es.cursoalcobendas.tienda.negocio;

import java.util.List;
import java.util.Set;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;

public interface Tienda {

	Fabricante buscarFabricante(Integer id);
	
	/**
	 * Busca todos los fabricantes
	 * 
	 * @return Set de fabricantes ordenado por nombre
	 */
	Set<Fabricante> buscarFabricantes();
	
	/**
	 * Busca los fabricantes que contengan "desc" en el nombre
	 * @param desc
	 * @return Set de fabricantes ordenado por id
	 */
	Set<Fabricante> buscarFabricantes(String desc);
	
	Fabricante crearFabricante(Fabricante nuevo);
	
	/**
	 * Buscar todos los productos del fabricante
	 * @param idFabInteger
	 * @return Set de productos ordenados por id
	 */
	Set<Producto> productosPorFabricante(Integer idFabricante);
	
	/**
	 * Retorna los cant productos de mayor precio, sin tener en cuenta los precios repetidos
	 * @param cant: cantidad de productos a devolver
	 * @return Lista de productos ordenados por precio de mayor a menor
	 */
	List<Producto> productosMayorPrecio(int cant);
}
