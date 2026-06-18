package arrays;

public class Array01 {
	public static void main(String[] args) {
		
		int[] nums1 = new int[10];
		muestraArray(nums1);
		for (int i = 0; i < nums1.length; i++) {
			nums1[i] = (int)Math.pow(2, i);
		}
		muestraArray(nums1);
		
		int[] potDiez = {1, 10, 100, 1000, 10000};
		muestraArray(potDiez);
		
		String[] cosas = new String[3];
		System.out.println(cosas[0]);
		cosas[0].toLowerCase();
	}
	
	public static void muestraArray(int[] v) {
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		System.out.println();
	}
}
