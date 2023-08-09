package collectionpkg;

import java.util.ArrayList;
import java.util.List;

public class ListIntStringEx {

	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add("a");
		list.add("b");
		list.add("c");
		for (Object o : list) {
			System.out.println(o);
		}
	}
	
}
