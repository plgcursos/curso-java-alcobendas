package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01Cutre {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3366/04_tienda";
		
		String sql = """
				select id_fabricante, fabricante
				from fabricantes
				""";
		
		try(Connection con = DriverManager.getConnection(url, "root", "root");
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery()) {
			
			while(rs.next()) {
				System.out.println(rs.getInt("id_fabricante") + ": " + rs.getString("fabricante"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
