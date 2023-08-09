package collectionpkg;

import java.util.ArrayList;
import java.util.List;

public class ListEx {
	
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list);
		
		Object oi = list.get(0);
		Integer ii = (Integer)oi;
//		int i = ii;
		int i = (int)oi;
		for (int j=0; j<list.size(); j++) {
			System.out.println(list.get(j));
		}
	}
	
}
