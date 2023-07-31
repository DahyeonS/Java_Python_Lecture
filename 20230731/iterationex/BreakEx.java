package iterationex;

public class BreakEx {

	public static void main(String[] args) {
		for (int j=0; j<5; j++) {
			for (int i=0; i<10; i++) {
				if (i == 5) break;
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println("====================");
		
		target:for (int j=0; j<5; j++) {
			for (int i=0; i<10; i++) {
				if (i == 5) break target;
				System.out.println(i);
			}
			System.out.println();
		}
		
		System.out.println("====================");
		
		for (int j=0; j<5; j++) {
			int k = 0;
			for (int i=0; i<10; i++) {
				k++;
				if (k == 5) break;
				System.out.println(i);
			}
			if (k == 5) break;
			System.out.println();
		}
		
		System.out.println("====================");
		
		int k = 0;
		while (k < 10) {
			if (k == 5) break;
			System.out.print(k + " ");
			k++;
		}
	}

}
