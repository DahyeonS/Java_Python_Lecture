package operatorex;

public class ArithmethicEx {

	public static void main(String[] args) {
		int x1 = 100;
		int x2 = 30;
		
//		Add
		int add = x1 + x2;
		
//		Sub
		int sub = x1 - x2;
		
//		Mul
		int mul = x1 * x2;
		
//		Mod
		int mod = x1 / x2;
		
//		정수 나눗셈 Div
		int iDiv = x1 / x2;
		double dDiv = x1 / x2;
		
//		실수 나눗셈 Div
		double dDiv2 = (double)x1 / x2;
		
		System.out.println(iDiv);
		System.out.println(dDiv);
		System.out.println(dDiv2);
	}

}
