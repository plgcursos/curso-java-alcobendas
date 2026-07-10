package excepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLException;

public class E02 {

	public static void main(String[] args) {
		
	}
	
	//arregla una y lanza la otra
	public static void m1() throws SQLException {
		try {
			metodoProblematico(3);
		} catch(FileNotFoundException e) {
			// arregle el problema de filenotfound
		}
	}
	
	//arregla las dos con soluciones diferentes
	public static void m2() {
		try {
			metodoProblematico(3);
		} catch(FileNotFoundException e) {
			// arregle el problema de filenotfound
		} catch (SQLException e) {
			// arreglo del problema sqlexception
		}
	}
	
	//arregla las dos con la misma solucion
	public static void m3() {
		try {
			metodoProblematico(3);
		} catch(FileNotFoundException | SQLException e) {
			//multicatch
			// arregla el problema de filenotfound y el de sql
		}
	}
	
	public static void m4() {
		try {
			metodoProblematico(3);
		} catch(Exception e) {
			// arregla cualquier problema (Exception)
		}
	}
	
	public static void metodoProblematico(int valor) throws FileNotFoundException, SQLException {
		String nada = null;
		int[] m = {1,5};
		
		switch(valor) {
			case 0 -> System.out.println(nada.toUpperCase());
			case 1 -> System.out.println(m[5]);
			case 2 -> new FileReader("algo");
			case 3 -> throw new SQLException("el cable tá roto!!");
		}
	}
}
