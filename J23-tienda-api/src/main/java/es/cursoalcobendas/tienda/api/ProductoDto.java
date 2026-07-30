package es.cursoalcobendas.tienda.api;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;

public record ProductoDto(
	Integer idProducto,
	String producto,
	Double precio,
	Integer idFabricante
	) {

	public static ProductoDto toDto(Producto p) {
		return new ProductoDto(p.getIdProducto(), p.getProducto(), p.getPrecio(), p.getFabricante().getIdFabricante());
	}
	
	public static Producto fromDto(ProductoDto dto, Fabricante f) {
		Producto p = new Producto(dto.producto(), dto.precio(), f);
		p.setIdProducto(dto.idProducto);
		return p;
	}
}
