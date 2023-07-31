package iterationex;

public class DoWhileEx {

	public static void main(String[] args) {
		int i = 10;
		
		do {
			System.out.print(i + " ");
		} while (i < 10);
		
		while (true) {
			System.out.print(i + " ");
			if (i >= 10) break;
		}
	}

}
