package variableex;

public class ColorChange {

	public static void main(String[] args) {
		String cupA = "Red";
		String cupB = "Green";
		
		// coding
		String temp = cupA;
		cupA = cupB;
		cupB = temp;
		
		System.out.printf("cupA : %s, cupB : %s", cupA, cupB);
//		cupA : Red, cupB : Green
//		cupA : Green, cupB : Red

	}

}
