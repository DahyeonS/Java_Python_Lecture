package javaapipkg;

public class StringBufferTest {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println(start);
		
		String str = "";
		for (int i=0; i<300000; i++) {
			str += i;
		}
		long end = System.currentTimeMillis();
		System.out.println("Time: " + (end - start) / 1000);
	}
}
