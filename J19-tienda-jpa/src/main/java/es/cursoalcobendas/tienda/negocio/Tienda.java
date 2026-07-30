package es.cursoalcobendas.tienda.negocio;

import java.util.List;
import java.util.Set;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;

public interface Tienda {

    Fabricante buscarFabricante(Integer id);

    /**
     * Busca todos los fabricantes.
     *
     * @return fabricantes ordenados por nombre
     */
    Set<Fabricante> buscarFabricantes();

    /**
     * Busca los fabricantes cuyo nombre contiene la descripción indicada.
     *
     * @param desc texto que debe aparecer en el nombre
     * @return fabricantes ordenados por id
     */
    Set<Fabricante> buscarFabricantes(String desc);

    Fabricante crearFabricante(Fabricante nuevo);

    /**
     * Busca todos los productos de un fabricante.
     *
     * @param idFabricante identificador del fabricante
     * @return productos ordenados por id
     */
    Set<Producto> productosPorFabricante(Integer idFabricante);

    /**
     * Retorna los productos de mayor precio, ignorando precios repetidos.
     *
     * @param cant cantidad máxima de productos
     * @return productos ordenados por precio de mayor a menor
     */
    List<Producto> productosMayorPrecio(int cant);

    List<Producto> buscarProductos();

    Producto buscarProducto(Integer id);

    Producto crearProducto(Producto nuevo);

    Producto modificarProducto(Integer id, Producto datos);

    boolean eliminarProducto(Integer id);
}
