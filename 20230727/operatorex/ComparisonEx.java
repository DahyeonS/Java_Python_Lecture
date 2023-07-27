package operatorex;

public class ComparisonEx {

	public static void main(String[] args) {
		int x1 = 100;
		int x2 = 10;
		
		boolean result = false;
		
//		== 동등 비교
		result = x1 == x2;
		System.out.println(result);
		
//		!=
		result = (x1 != x2);
		System.out.println(result);
		
//		>
		result = (x1 > x2);
		System.out.println(result);
		
//		>=
		result = (x1 >= x2);
		System.out.println(result);
		
//		<
		result = (x1 < x2);
		System.out.println(result);
		
//		<=
		result = (x1 <= x2);
		System.out.println(result);
	}

}
