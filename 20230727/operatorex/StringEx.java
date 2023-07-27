package operatorex;

public class StringEx {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "hello"; // s1 참조
		boolean result = false;
		
		result = s1 == s2; // 주소 값 비교
		System.out.println(result); // true
		result = s1.equals(s2); // 값 비교
		System.out.println(result); // true
		
		String s3 = new String("hello");
		String s4 = new String("hello");
		result = s3 == s4; // 주소 값 비교
		System.out.println(result); // false
		result = s3.equals(s4); // 값 비교
		System.out.println(result); // true
		
		System.out.println(System.identityHashCode(s1)); // 1365202186
		System.out.println(System.identityHashCode(s2)); // 1365202186
		System.out.println(System.identityHashCode(s3)); // 1651191114
		System.out.println(System.identityHashCode(s4)); // 1586600255
		
		s3 = s1 + s2; // 문자열 + 문자열
		System.out.println(s3); // hellohello
		s4 = s1 + " " + 3; // 문자열 + 숫자(기본형)
		System.out.println(s4); // hello3
		
//		문자열 숫자 변환 => 정수
		String iS = "100";
		int i = Integer.parseInt(iS);
		System.out.println(i + 100); // 200
		
		String dS = "3.14";
		double d = Double.parseDouble(dS);
		System.out.println(i + 100 + d); // 203.14
	}

}
