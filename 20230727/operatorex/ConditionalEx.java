package operatorex;

public class ConditionalEx {

	public static void main(String[] args) {
		int x1 = 100;
		int x2 = 10;
		
		int iResult = 0;
		String sResult = "";
		
		iResult = (x1 > x2) ? (x1 - x2) : (x2 - x1);
		sResult = (x1 > x2) ? "x1이 크다!!" : "x2가 크다!!";
		
		System.out.println(iResult);
		System.out.println(sResult);
	}

}
