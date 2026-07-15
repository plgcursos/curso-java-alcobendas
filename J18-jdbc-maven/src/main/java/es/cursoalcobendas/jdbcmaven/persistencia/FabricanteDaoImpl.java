package es.cursoalcobendas.jdbcmaven.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import es.cursoalcobendas.jdbcmaven.exceptions.MiSQLException;
import es.cursoalcobendas.jdbcmaven.modelo.Fabricante;

public class FabricanteDaoImpl implements FabricanteDao {

	private DataSource ds;
	
	public FabricanteDaoImpl() {
		ds = Ds.getInstance();
	}
	
	@Override
	public List<Fabricante> findAll() {
		List<Fabricante> resu = new LinkedList<>();
		String sql = """
				select id_fabricante, fabricante
				from fabricantes
				""";
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){

			try(ResultSet rs = ps.executeQuery()){
				Fabricante fab;
				while(rs.next()) {
//					resu.add(new Fabricante(rs.getInt("id_fabricante"), rs.getString("fabricante")));
					fab = new Fabricante(rs.getInt("id_fabricante"), rs.getString("fabricante"));
					resu.add(fab);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiSQLException(e);
		}
		return resu;
	}

	@Override
	public Fabricante insert(Fabricante f) {
		String sql = """
				insert into fabricantes
				(fabricante)
				values(?)
				""";
		try(Connection con = ds.getConnection()) {
			
			try(PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
				con.setAutoCommit(false);
				
				ps.setString(1, f.getFabricante());
				
				int filas = ps.executeUpdate();
				
				if (filas == 0) {
					con.rollback();
					throw new MiSQLException();
				}
				
				con.commit();
				
				try(ResultSet claves = ps.getGeneratedKeys()) {
					if (claves.next())
						f.setIdFabricante(claves.getInt(1));
				}
			} catch (SQLException e) {
				con.rollback();
				throw new MiSQLException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiSQLException(e);
		}
		return f;
	}

	@Override
	public List<Fabricante> findByNombre(String nombre) {
		List<Fabricante> resu = new LinkedList<>();
		String sql = """
				select id_fabricante, fabricante
				from fabricantes
				where fabricante like ?
				""";
		try(Connection con = ds.getConnection();
			PreparedStatement ps = con.prepareStatement(sql)){

			ps.setString(1, "%" + nombre + "%");
			
			try(ResultSet rs = ps.executeQuery()){
				Fabricante fab;
				while(rs.next()) {
//					resu.add(new Fabricante(rs.getInt("id_fabricante"), rs.getString("fabricante")));
					fab = new Fabricante(rs.getInt("id_fabricante"), rs.getString("fabricante"));
					resu.add(fab);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MiSQLException(e);
		}
		return resu;
	}

}
