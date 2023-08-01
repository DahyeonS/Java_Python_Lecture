package arrayex;

public class ArrayScopeEx {

	static void arrayScope(int x, int[] arr) {
		System.out.println("1. " + x); // 1. 5
		System.out.println("2. " + arr[0]); // 2. 5
		x = 10;
		arr[0] = 10;
		System.out.println("3. " + x); // 3. 10
		System.out.println("4. " + arr[0]); // 4. 10
	}
	
	public static void main(String[] args) {
		int x = 5;
		int[] arr = new int[1];
		arr[0] = 5;
		arrayScope(x, arr); // x 값은 변동없음
		
		System.out.println("5. " + x); // 5. 5
		System.out.println("6. " + arr[0]); // 6. 10
	}
}
