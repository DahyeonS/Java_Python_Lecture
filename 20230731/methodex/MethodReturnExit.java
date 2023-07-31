package methodex;

public class MethodReturnExit {
	
	public static void addPrint(int x) {
		if (x == 0) {
			System.out.println("End");
			return;
		}
		int y = x + x;
		System.out.println(y);
	}
	
	public static void main(String[] args) {
		int x = 100;
		addPrint(x);
	}
}
