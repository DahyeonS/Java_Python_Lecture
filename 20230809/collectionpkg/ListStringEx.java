package collectionpkg;

import java.util.ArrayList;
import java.util.List;

public class ListStringEx {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		System.out.println(list);
		
		Object os = list.get(0);
		String ss = (String)os;
		for (int j=0; j<list.size(); j++) {
			System.out.print(list.get(j) + " ");
		}
		System.out.println();
		for (Object o : list) {
			String s = (String)o;
			System.out.print(s + " ");
		}
	}
	
}
