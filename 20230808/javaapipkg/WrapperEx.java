package javaapipkg;

public class WrapperEx {

	public static void main(String[] args) {
		int i1 = 10; // 기본형
//		Integer i2 = new Integer(i1); // 최신 버전 불가능
		Integer i2 = i1; // 자동 형변환
		i1 = i2;
		
		int mv = Integer.MAX_VALUE;
		System.out.println(mv); // 2147483647
		long mv2 = Long.MAX_VALUE;
		System.out.println(mv2); // 9223372036854775807
		float mv3 = Float.MAX_VALUE;
		System.out.println(mv3); // 3.4028235E38
		double mv4 = Double.MAX_VALUE;
		System.out.println(mv4); // 1.7976931348623157E308
		
		System.out.println(Double.SIZE); // 64
	}

}
