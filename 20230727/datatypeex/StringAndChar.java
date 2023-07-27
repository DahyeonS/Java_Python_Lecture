package datatypeex;

public class StringAndChar {

	public static void main(String[] args) {
		
//		01. 문자 'a'를 문자열 "a"로 변경하기
		char a ='a';
		
//		String s = a; // Error
		
		String s = "" + a;
		System.out.println(s);
		
//		02. 문자열 "a"를 문자열 'a'로 변경하기
		a = s.charAt(0);
		System.out.println(a);
		
//		03. 문자열 "a"를 대문자 'A'로 변경하기
		String S = s.toUpperCase();
		System.out.println(S);
		
	}

}
