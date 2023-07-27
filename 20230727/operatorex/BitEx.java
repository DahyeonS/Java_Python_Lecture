package operatorex;

public class BitEx {

	public static void main(String[] args) {
		int x1 = 7;
		int x2 = 7;
		
//		7 & 7 == 111 & 111 == 7
		int result = x1 & x2;
		System.out.println(result);
		
//		7 & 6 == 111 & 110 == 6
		x2 = 6;
		result = x1 & x2;
		System.out.println(result);
		
//		7 & 1 == 111 & 001 == 1
		x2 = 1;
		result = x1 & x2;
		System.out.println(result);
		
//		7 | 6 == 111 | 110 == 7
		x2 = 6;
		result = x1 | x2;
		System.out.println(result);
		
//		7 | 1 == 111 | 001 == 7
		x2 = 1;
		result = x1 | x2;
		System.out.println(result);
		
	}

}
