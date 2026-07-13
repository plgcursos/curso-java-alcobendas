package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO01LeeFicheroHorrible {

	public static void main(String[] args) {
		
		String fichero = "datos.txt";
		
		FileReader fr = null;
		try {
			fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			
			String linea;
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}
}
