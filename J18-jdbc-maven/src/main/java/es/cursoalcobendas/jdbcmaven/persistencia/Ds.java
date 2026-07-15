package es.cursoalcobendas.jdbcmaven.persistencia;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import es.cursoalcobendas.jdbcmaven.config.Prop;

//Implementa el patrón Singleton
public class Ds {

	private static DataSource ds;
	
	private Ds() {}
	
	public static DataSource getInstance() {
		if (ds == null) {
			BasicDataSource bds = new BasicDataSource();
			bds.setUrl(Prop.get().getProperty("url"));
			bds.setUsername(Prop.get().getProperty("usr"));
			bds.setPassword(Prop.get().getProperty("pwd"));
			ds = bds;
		}
		return ds;
	}

}
