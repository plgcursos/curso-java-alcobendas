package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		
		String[] nombresArray = 
			{"Santiago Andrés", "Geor", "Oscar", "Borja", "Marta Angela", 
					"Daniel David", "Ruben", "Dani", "Manuel Enrique"
			};
		
		List<String> nombresList = List.of("Santiago Andrés", "Geor", "Oscar", "Borja", "Marta Angela", 
				"Daniel David", "Ruben", "Dani", "Manuel Enrique");
		
		Set<String> nombresSet = new TreeSet<String>(nombresList);
		
		
		nombresList.stream().forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});
		
		Stream<String> strList = nombresList.stream();
		
		nombresList.stream().forEach((String a) -> {System.out.println(a);});
		nombresList.stream().forEach(a -> System.out.println(a));
		nombresList.stream().forEach(System.out::println);
		
		nombresList.forEach((String a) -> {System.out.println(a);});
		nombresList.forEach(a -> System.out.println(a));
		nombresList.forEach(System.out::println);
		
		//Set
		nombresSet.forEach(System.out::println);
		
		//Array
		Stream<String> strArr = Arrays.stream(nombresArray);
		
		strArr.forEach(System.out::println);
		
//		strArr.forEach(s -> System.out.println(s.toUpperCase()));
		
		
		procesaStream(nombresList.stream());
		procesaStream(nombresSet.stream());
		procesaStream(Arrays.stream(nombresArray));
		
	}
	
	
	public static void procesaStream(Stream<String> str) {
		str.forEach(System.out::println);
	}
}
