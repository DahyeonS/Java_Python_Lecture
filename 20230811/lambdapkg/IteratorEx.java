package lambdapkg;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorEx {

	public static void main(String[] args) {
		String[] names = {"hong", "kim", "lee", "kang"};
		List<String> list = Arrays.asList(names);
		
//		1. for 반복문
		for (int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println();
		
//		2. 향상된 for 반복문
		for (String s : list) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
//		3. Iterator 반복문
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String s = it.next();
			System.out.print(s + " ");
		}
		
		System.out.println();
		
//		4. Stream
		list.stream().forEach(s -> System.out.print(s + " "));
	}

}
