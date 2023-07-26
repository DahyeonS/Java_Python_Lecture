package printex;

public class PrintTest {
	
	public static void main(String[] args) {
		System.out.printf("%s는 %d번입니다.\n", "Red", 1);
		System.out.printf("10진수: %d, 16진수: %x", 10, 10);
		System.out.println();
		System.out.printf("Red%nGreen%nBlue"); // %n은 printf에서만 가능
	}

}
