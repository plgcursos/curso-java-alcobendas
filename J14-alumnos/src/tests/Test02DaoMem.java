package tests;

import modelo.Alumno;
import persistencia.AlumnoDao;
import persistencia.AlumnoDaoMem;

public class Test02DaoMem {
	public static void main(String[] args) {
		
		AlumnoDao aDao = new AlumnoDaoMem();
		
		aDao.deleteById("03437498X");
		
		aDao.save(new Alumno("Nuevo", "Nuevo", "NuevomON", "NUEVO", 7));
		
		aDao.findAll().forEach(System.out::println);
		System.out.println(aDao.findAll().size());
		System.out.println("-----------------");
		
		aDao.findAllByNombre("mon").forEach(System.out::println);
		
		System.out.println(aDao.findById("nuevo"));
	}
}
