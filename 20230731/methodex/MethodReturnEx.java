package methodex;

public class MethodReturnEx {
	
	public static int pow(int x) {
		int y = x * x;
		return y;
	}
	
	public static void addPrint(int x) {
		int y = x + x;
		System.out.println(y);
	}

	public static void main(String[] args) {
		int p = pow(10);
		System.out.println(p);
		addPrint(10);
	}

}
