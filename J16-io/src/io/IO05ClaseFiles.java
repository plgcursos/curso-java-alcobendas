package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class IO05ClaseFiles {
	public static void main(String[] args) throws IOException {
		
		Path p1 = Path.of("datos.txt");
		
//		System.out.println(Files.exists(p1));
//		
//		System.out.println(Files.notExists(p1));
		
		
		//LECTURA
		
		//readString() - Lee el contenido completo y retorna un String
		String contenido = Files.readString(p1);
//		System.out.println(contenido);

		//readAllLines() - Lee el contenido completo y retorna un List<String> con cada línea
		List<String> listaCont = Files.readAllLines(p1);
		System.out.println(listaCont.get(0));
		
		//lines() - Generar un Stream<String>
		Stream<String> str = Files.lines(p1);
		str.forEach(System.out::println);
		
		//ESCRITURA
		//writeString() - Graba el conenido del String
		Path nuevo = Path.of("nuevo.txt");
		String quijote = """
				En un lugar de la Mancha, de cuyo nombre no quiero acordarme, no ha
				mucho tiempo que vivÃ­a un hidalgo de los de lanza en astillero, adarga
				antigua, rocÃ­n flaco y galgo corredor. Una olla de algo mÃ¡s vaca que
				carnero, salpicÃ³n las mÃ¡s noches, duelos y quebrantos los sÃ¡bados,
				lentejas los viernes, algÃºn palomino de aÃ±adidura los domingos,
				consumÃ­an las tres partes de su hacienda. El resto della concluÃ­an
				sayo de velarte, calzas de velludo para las fiestas con sus pantuflos
				de lo mismo, los dÃ­as de entre semana se honraba con su vellori de lo
				mÃ¡s fino. TenÃ­a en su casa una ama que pasaba de los cuarenta, y una
				sobrina que no llegaba a los veinte, y un mozo de campo y plaza, que
				asÃ­ ensillaba el rocÃ­n como tomaba la podadera. Frisaba la edad de
				nuestro hidalgo con los cincuenta aÃ±os, era de complexiÃ³n recia, seco
				de carnes, enjuto de rostro; gran madrugador y amigo de la
				caza. Quieren decir que tenÃ­a el sobrenombre de Quijada o Quesada (que
				en esto hay alguna diferencia en los autores que deste caso escriben),
				aunque por conjeturas verosÃ­miles se deja entender que se llama
				Quijana; pero esto importa poco a nuestro cuento; basta que en la
				narraciÃ³n dÃ©l no se salga un punto de la verdad.
				""";
	}
}
