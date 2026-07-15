package es.cursoalcobendas.jdbcmaven.config;

import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;

public class Prop {

	private static Properties prop;
	private static final String FICH = "app.properties";
	
	private Prop() {}
	
	public static Properties get() {
		if (prop == null) {
			prop = new Properties();
			
			try(FileReader fr = new FileReader(FICH)){
				prop.load(fr);
			} catch (IOException e) {
				e.printStackTrace(); //esto sería el log
				throw new UncheckedIOException(e);
			}
		}
		return prop;
	}
}
