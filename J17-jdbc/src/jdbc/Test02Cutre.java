package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test02Cutre {
	
	public static void save(Fabricante fab) {
		
		String url = "jdbc:mysql://localhost:3366/04_tienda";
		
		String sql = """
				insert into fabricantes
				values(NULL, ?);
				""";
		
		try(Connection con = DriverManager.getConnection(url, "root", "root");
			PreparedStatement ps = con.prepareStatement(sql)
			) {
			
			ps.setString(1, fab.getFabricante());
			
			int filas = ps.executeUpdate();
			
			if (filas == 1)
				System.out.println("TODO FENOMENAL");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Fabricante nuevo = new Fabricante("IBM");
		save(nuevo);
	}
	
	static class Fabricante {
		private Integer idFabricante;
		private String fabricante;
		
		public Fabricante(String fabricante) {
			this.fabricante = fabricante;
		}

		public Integer getIdFabricante() {
			return idFabricante;
		}

		public void setIdFabricante(Integer idFabricante) {
			this.idFabricante = idFabricante;
		}

		public String getFabricante() {
			return fabricante;
		}

		public void setFabricante(String fabricante) {
			this.fabricante = fabricante;
		}
	}
}
