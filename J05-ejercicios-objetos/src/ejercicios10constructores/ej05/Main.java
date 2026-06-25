package ejercicios10constructores.ej05;

class A {
	public A() {
		System.out.println("Constructor de A");
	}
}

class B extends A {
	public B() {
		System.out.println("Constructor de B");
	}
}

class C extends B {
	public C() {
		System.out.println("Constructor de C");
	}
}

public class Main {
	public static void main(String[] args) {
		C objeto = new C();
	}
}
