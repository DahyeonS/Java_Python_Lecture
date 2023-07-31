package iterationex;

public class WhileEx {

	public static void main(String[] args) {
		for (int i=1; i<6; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		int k = 1;
		while (k < 6) {
			System.out.print(k + " ");
			k++;
		}
		System.out.println();
		k = 5;
		while (k > 0) {
			System.out.print(k + " ");
			k--;
		}
		System.out.println();
		k = 1;
		while (k < 11) {
			if (k % 2 == 0) System.out.print(k + " ");
				k++;
		}
	}

}
