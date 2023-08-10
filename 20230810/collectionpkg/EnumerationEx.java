package collectionpkg;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class EnumerationEx {

	public static void main(String[] args) {
		Vector v = new Vector();
		for (int i=1; i<6; i++) {
			v.add(i);
		}
		
		Enumeration et = v.elements();
		while (et.hasMoreElements()) {
			System.out.print(et.nextElement() + " ");
		}
		
		System.out.println();
		
		Iterator it = v.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

}
