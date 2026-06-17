package strings;

public class CadenasConcatenacion {

	public static void main(String[] args) {
		String s = "";
		long t0, tf;

		StringBuilder sb = new StringBuilder("");
		StringBuffer sbf = new StringBuffer("");
		
		t0 = System.currentTimeMillis();
		for (int i = 1; i <= 400_000; i++) {
			s += "x";
		}
		tf = System.currentTimeMillis();
		System.out.println("String: " + (tf - t0));
		
		t0 = System.currentTimeMillis();
		for (int i = 1; i <= 40_000_000; i++) {
			sb.append("x");
		}
		tf = System.currentTimeMillis();
		System.out.println("StringBuilder: " + (tf - t0));
		
		t0 = System.currentTimeMillis();
		for (int i = 1; i <= 40_000_000; i++) {
			sbf.append("x");
		}
		tf = System.currentTimeMillis();
		System.out.println("StringBuffer: " + (tf - t0));
		
	}
}
