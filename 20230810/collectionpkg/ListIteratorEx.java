package collectionpkg;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx {

	public static void main(String[] args) {
		List list = new ArrayList();
		for (int i=1; i<6; i++) {
			list.add(i);
		}
		
		ListIterator lit = list.listIterator();
		while (lit.hasNext()) {
			System.out.print(lit.next() + " "); // 커서 또는 포인터는 EoF, false
		}
		
		System.out.println();
		
		while (lit.hasPrevious()) {
			System.out.print(lit.previous() + " ");
		}
	}

}
