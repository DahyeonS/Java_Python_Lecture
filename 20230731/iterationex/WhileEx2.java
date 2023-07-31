package iterationex;

public class WhileEx2 {

	public static void main(String[] args) {
		int i = 0;
		while (i < 5) {
			int j = 1;
			while (j < 6) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
