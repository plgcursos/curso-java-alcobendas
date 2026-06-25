package ejercicios10constructores.ej03;

public class CuentaBancaria {
	public String titular;
	public double saldo;
	
	public CuentaBancaria(String titular) {
		this.titular = titular;
	}

	public CuentaBancaria(String titular, double saldo) {
		this(titular);
		this.saldo = saldo >= 0 ? saldo : 0;
	}
	
	public void mostrarCuenta() {
		System.out.println("Titular: " + titular + " - Saldo: " + saldo);
	}
	
	public void ingresar(double cantidad) {
		if (cantidad <= 0) {
			System.out.println("El ingreso debe ser mayor que 0");
			return;
		}
		saldo += cantidad;
	}
	
	public void retirar(double cantidad) {
		if (cantidad <= 0) {
			System.out.println("El reintegro debe ser mayor que 0");
			return;
		}
		if (cantidad > saldo) {
			System.out.println("Saldo insuficiente");
			return;
		}
		saldo -= cantidad;
	}

}
