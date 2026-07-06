package interfaces.conflicto;

//public class Saludador extends Persona {  //Hola que tal
//public class Saludador implements SaludoDia {  //Buenos días
//public class Saludador extends Persona implements SaludoDia {  //Hola que tal, tiene preferencia la herencia
//public class Saludador implements SaludoDia, SaludoTarde {  //Estamos obligados a sobre-escribirlo
public class Saludador extends Persona implements SaludoDia, SaludoTarde {  //Hola que tal, tiene preferencia la herencia

	@Override
	public void saluda() {
		super.saluda();
		SaludoDia.super.saluda();
		SaludoTarde.super.saluda();
		System.out.println("Adiosssss");
	}
	
	public static void main(String[] args) {
		Saludador s = new Saludador();
		s.saluda();
	}
}
