package ejercicios10constructores.ej03;

public class TestEj03 {

	public static void main(String[] args) {
		CuentaBancaria c1 = new CuentaBancaria("Marta");
		CuentaBancaria c2 = new CuentaBancaria("Luis", 500);
		CuentaBancaria c3 = new CuentaBancaria("Eva", -100);
		
		c1.mostrarCuenta();
		c2.mostrarCuenta();
		c3.mostrarCuenta();
		
		c2.ingresar(-100);
		c2.ingresar(100);
		c2.mostrarCuenta();
		
		c2.retirar(-100);
		c2.retirar(1000);
		c2.retirar(200);
		c2.mostrarCuenta();
	}

}
