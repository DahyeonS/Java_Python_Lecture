package javaapipkg;

public class StringEx2 {
	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "abcd";
		System.out.println(System.identityHashCode(str1)); // 1023487453
		System.out.println(System.identityHashCode(str2)); // 1023487453
		
		str1 = str1 + "efg";
		System.out.println(System.identityHashCode(str1)); // 1651191114

		StringBuffer sb1 = new StringBuffer("abcd");
		System.out.println(System.identityHashCode(sb1)); // 474675244
		sb1.append("efg");
		System.out.println(System.identityHashCode(sb1)); // 474675244
		System.out.println(sb1.equals("abcdefg")); // false
		System.out.println(sb1.equals(str1)); // false
	}
}
