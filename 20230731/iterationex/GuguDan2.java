package iterationex;

public class GuguDan2 {

	public static void main(String[] args) {
//		2 * 1 = 2
//		2 * 2 = 4
//		2 * 3 = 6
//		...
//		2 * 9 = 8
		int dan = 2;
		int k = 1;
		while (k < 10) {
			System.out.printf("%s * %s = %s%n", dan, k, (dan*k));
			k++;
		}
	}

}
