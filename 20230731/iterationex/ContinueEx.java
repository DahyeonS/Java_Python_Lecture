package iterationex;

public class ContinueEx {

	public static void main(String[] args) {
		for (int i=0; i<11; i++) {
			if (i == 5) continue;
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		for (int i=0; i<11; i++) {
			if (i % 2 == 0) continue;
			System.out.print(i + " ");
		}
		
		for(;;) {
			break;
		}
		while (true) {
			break;
		}
	}

}
