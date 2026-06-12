package introduccion.ejemplos;

public class T20_CompatibilidadTiposDato {
	public static void main(String[] args) {
		byte b = 15;
		short s = b;
		int i = s;
		long l = i;
		float f = l;
		double d = f;
		
		System.out.println(b);
		System.out.println(s);
		System.out.println(i);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(d);
		
		i = Integer.MAX_VALUE;
		System.out.println(i);
		l = i;
		System.out.println(l);
		f = i;
		System.out.println(f);
		d = i;
		System.out.println(d);
		
		l = Long.MAX_VALUE;
		f = l;
		d = l;
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
	}
}
