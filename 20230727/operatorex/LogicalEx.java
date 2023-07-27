package operatorex;

public class LogicalEx {

	public static void main(String[] args) {
		int x1 = 100;
		int x2 = 10;
		
		boolean result = false;
		
//		AND
//		true && true
		result = (x1 == 100) && (x2 == 10);
		System.out.println(result);
		
//		true && false
		result = (x1 == 100) && (x2 > 10);
		System.out.println(result);
		
//		false && true
		result = (x1 < 100) && (x2 == 10);
		System.out.println(result);
		
//		false && false
		result = (x1 < 100) && (x2 > 10);
		System.out.println(result);
		
		System.out.println("======================");
		
//		OR
//		true || true
		result = (x1 == 100) || (x2 == 10);
		System.out.println(result);
		
//		true || false
		result = (x1 == 100) || (x2 > 10);
		System.out.println(result);
		
//		false || true
		result = (x1 < 100) || (x2 == 10);
		System.out.println(result);
		
//		false || false
		result = (x1 < 100) || (x2 > 10);
		System.out.println(result);
		
		System.out.println("======================");
		
//		NOT
//		!true
		result = !true;
		System.out.println(result);
		
//		!false
		result = !false;
		System.out.println(result);
		
//		!true
		result = !(x1 == 100);
		System.out.println(result);
		
//		!false
		result = !(x1 < 100);
		System.out.println(result);
		
//		!(true || true)
		result = !((x1 == 100) || (x2 == 10));
		System.out.println(result);
		
	}

}
