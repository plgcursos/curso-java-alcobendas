package es.cursoalcobendas.tienda.api;

import java.io.IOException;
import java.util.List;

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
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<ProductoDto> resu = neg.buscarProductos().stream().map(ProductoDto::toDto).toList();
		
		mapper.writeValue(resp.getWriter(), resu);
		
	}
}
