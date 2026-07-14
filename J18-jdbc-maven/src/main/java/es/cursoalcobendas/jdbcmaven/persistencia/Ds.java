package es.cursoalcobendas.jdbcmaven.persistencia;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

//Implementa el patrón Singleton
public class Ds {

	private static DataSource ds;
	
	private Ds() {}
	
	public static DataSource getInstance() {
		if (ds == null) {
			BasicDataSource bds = new BasicDataSource();
			bds.setUrl("url");
			bds.setUsername("usr");
			bds.setPassword("pwd");
			ds = bds;
		}
		return ds;
	}
}
