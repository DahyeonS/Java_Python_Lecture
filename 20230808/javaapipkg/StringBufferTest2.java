package javaapipkg;

public class StringBufferTest2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(start);
		
		StringBuffer str = new StringBuffer();
		for (int i=0; i<3000000; i++) {
			str.append(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start)); // String 연산에 비해 시간단축
	}
}
