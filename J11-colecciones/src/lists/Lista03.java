package lists;

import java.util.ArrayList;
import java.util.List;

public class Lista03 {

	public static void main(String[] args) {
		List<String> nombres = new ArrayList<String>();
		nombres.add("Oscar");
		nombres.add("Borja");
		nombres.add("Marta");
		recorre(nombres);
		
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(159);
		nums.add(666);
		nums.add(890);
		nums.add(2360);
		recorre(nums);
	}
	
	public static <T> void recorre(List<T> lista) {
		for (T s : lista) {
			System.out.println(s);
		}
	}
}
