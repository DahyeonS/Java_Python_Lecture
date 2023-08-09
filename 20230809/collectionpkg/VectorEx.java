package collectionpkg;

import java.util.Vector;

public class VectorEx {

	public static void main(String[] args) {
		Vector list = new Vector();
		list.add(1.2);
		list.add(Math.PI);
		list.addElement(3.4);
		
		for (Object o : list) {
			System.out.print(o + " ");
		}
		
		System.out.println();
		
		double num = 3.4;
		int index = list.indexOf(num);
		System.out.println(index); // 2
		/*
		double num = 3.41;
		int index = list.indexOf(num);
		if (index == -1) System.out.println("not found!!");
		else System.out.println(index);
		*/
		boolean b = list.contains(num);
		if (b) System.out.println(num + " >> "+ index);
		else System.out.println("not found!!");
	}
	
}
