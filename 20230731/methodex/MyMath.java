package methodex;

public class MyMath {
	public static int pow(int x) {
		int y = x * x;
		return y;
	}
	
	public static int add(int x1, int x2) {
		int y = x1 + x2;
		return y;
	}
	
	public static int randomInt(int x) {
		int y = (int)(Math.random() * x);
		return y;
	}
}
