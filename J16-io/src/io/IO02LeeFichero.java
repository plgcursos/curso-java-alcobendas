package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IO02LeeFichero {

	public static void main(String[] args) {
		
		String fichero = "datos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
			
			String linea;
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
