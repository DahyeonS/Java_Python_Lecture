package iterationex;

public class GuguDan {

	public static void main(String[] args) {
//		2 * 1 = 2
//		2 * 2 = 4
//		2 * 3 = 6
//		...
//		2 * 9 = 8
		for (int i=1; i<10; i++) {
			System.out.printf("2 * %s = %s %n", i, i * 2);
		}
		
		System.out.println("===================================");
		
		for (int i=1; i<=9; i++) {
			System.out.println(2 + " * " + i + " = " + (i * 2));
		}
		
		System.out.println("===================================");
		
		int dan = 3;
		for (int i=1; i<10; i++) {
			System.out.printf("%s * %s = %s %n", dan, i, i * dan);
		}
	}

}
