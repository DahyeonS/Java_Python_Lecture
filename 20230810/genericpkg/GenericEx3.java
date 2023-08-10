package genericpkg;

import java.util.HashMap;
import java.util.Map;

public class GenericEx3 {

	public static void main(String[] args) {
		Generic2<String, Integer> gen1 = new Generic2<String, Integer>();
		gen1.set("hong", 1111);
		System.out.println(gen1.getName());
		System.out.println(gen1.getId());
		
		Generic2<String, String> gen2 = new Generic2<String, String>();
		gen2.set("lee", "2222");
		System.out.println(gen2.getName());
		System.out.println(gen2.getId());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("hong", 1111);
		map.put("lee", 2222);
	}
	
}
