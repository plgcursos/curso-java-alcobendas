package tests;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

import modelo.Alumno;
import util.CargaAlumnos;

public class Test01 {
	public static void main(String[] args) {
		
		Alumno[] alu = CargaAlumnos.getArrayAlumnos();
//		for (Alumno alumno : alu) {
//			System.out.println(alumno);
//		}
		
		Map<String, Alumno> alumnos = new TreeMap<>();
		
		Arrays.stream(alu).forEach(a -> alumnos.put(a.getDni(), a));
		
		alumnos.values().forEach(System.out::println);
		System.out.println();
		
		System.out.println(alumnos.get("56034423Y"));
		System.out.println();
		
		alumnos.values()
			.stream()
			.sorted(Alumno.getNombreComparator())
			.forEach(System.out::println);
	}
}
