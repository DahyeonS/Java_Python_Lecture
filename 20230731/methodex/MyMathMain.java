package methodex;

import methodex.MyMath;

public class MyMathMain {
	public static void main(String[] args) {
		int y1 = MyMath.pow(10);
		int y2 = MyMath.add(10, 20);
//		System.out.println(y1);
//		System.out.println(y2);
		
		for (int i=0; i<10; i++) {
			int r = MyMath.randomInt(100); // 0 ~ 100
			System.out.print(r + " ");
		}
	}
}
