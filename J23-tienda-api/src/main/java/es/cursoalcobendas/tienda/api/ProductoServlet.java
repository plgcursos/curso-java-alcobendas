package es.cursoalcobendas.tienda.api;

import java.io.IOException;
import java.util.List;

import es.cursoalcobendas.tienda.modelo.Fabricante;
import es.cursoalcobendas.tienda.modelo.Producto;
import es.cursoalcobendas.tienda.negocio.Tienda;
import es.cursoalcobendas.tienda.negocio.TiendaImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@WebServlet("/api/productos/*")
public class ProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ObjectMapper mapper = new ObjectMapper();
	private Tienda neg = new TiendaImpl();

	/*
	 * GET /api/productos o /api/productos/ devolver todos los productos GET
	 * /api/productos/5 devuelve el producto con id 5
	 */

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getPathInfo();

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		if (path == null || path.equals("/")) {
			List<ProductoDto> resu = neg.buscarProductos().stream().map(ProductoDto::toDto).toList();

			mapper.writeValue(resp.getWriter(), resu);
			return;
		}

		//Tendriamos que controlar que el path contiene un valor numerico
		Integer id = Integer.valueOf(path.substring(1));
		
		Producto p = neg.buscarProducto(id);
		if (p == null) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto inexistente");
			return;
		}
		
		mapper.writeValue(resp.getWriter(), ProductoDto.toDto(p));
	}
	
	/*
	 * POST /api/productos   (y en el cuerpo va un json)
	 * {"producto": "Teclado", "precio": 40.28, "idFabricante": 1}
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		
		//Controla que el json recibido es valido
		ProductoDto recibido = mapper.readValue(req.getReader(), ProductoDto.class);
		
		Fabricante f = neg.buscarFabricante(recibido.idFabricante());
		
		if (f != null) {
			Producto nuevo = ProductoDto.fromDto(recibido, f);
			Producto saved = neg.crearProducto(nuevo);
			
			resp.setStatus(HttpServletResponse.SC_CREATED);
			
			mapper.writeValue(resp.getWriter(), ProductoDto.toDto(saved));

		}
	}
}
