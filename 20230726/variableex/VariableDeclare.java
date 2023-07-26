package variableex;

public class VariableDeclare {

	public static void main(String[] args) {
//		int i;
//		String s;
//		
//		System.out.println(i); // Error
//		
//		i = 100;
//		s = "홍길동";
//		
//		System.out.println(i);
//		System.out.println(s);
		
		int i = 0;
		String s = "";
		String s2 = " ";
		int i1 = s2.length();
		boolean b = (i == i1);
		
		System.out.println(i);
		System.out.println(s.length());
		System.out.println(s2.length()); // 공백 출력
		System.out.println(b);
	}

}
